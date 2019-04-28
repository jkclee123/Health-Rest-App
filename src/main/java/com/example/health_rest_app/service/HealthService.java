package com.example.health_rest_app.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.health_rest_app.entity.MeasurementsEntity;
import com.example.health_rest_app.entity.PersonEntity;
import com.example.health_rest_app.model.AgeStatResponse;
import com.example.health_rest_app.model.BMIResponse;
import com.example.health_rest_app.repository.MeasurementsRepository;
import com.example.health_rest_app.repository.PersonRepository;
import com.example.health_rest_app.utils.HealthUtils;
import com.example.health_rest_app.utils.RangeUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HealthService {

	final Logger logger = LoggerFactory.getLogger(HealthService.class);
  @Autowired
  PersonRepository personRepository;

  @Autowired
  MeasurementsRepository measurementsRepository;

  private static DecimalFormat df2 = new DecimalFormat("#.##");

  public void insertPerson(PersonEntity req){
    PersonEntity existPerson = this.getPersonById(req.getId());
    if (existPerson != null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person already exist");
    }
    personRepository.save(req);
  }

  public List<PersonEntity> getAllPerson() {
    List<PersonEntity> personList = new ArrayList<>();
    personRepository.findAll().forEach(personList::add);
    return personList;
  }

  public PersonEntity getPersonById(Integer personId) {
    if (personId == null) return null;
    return personRepository.findById(personId).orElse(null);
  }

  public void deletePersonById(Integer personId) {
    try{
      personRepository.deleteById(personId);
    } catch (IllegalArgumentException e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person does not exist");
    }
  }

  public void insertMeasurements(MeasurementsEntity req) {
    MeasurementsEntity existMeasurements = this.getMeasurementsByPersonId(req.getPerson().getId());
    if (existMeasurements != null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Record does not exist");
    }
    measurementsRepository.save(req);
  }

  public List<MeasurementsEntity> getAllMeasurements() {
    List<MeasurementsEntity> measurementsList = new ArrayList<>();
    measurementsRepository.findAll().forEach(measurementsList::add);
    return measurementsList;
  }

  public MeasurementsEntity getMeasurementsByPersonId(Integer personId) {
    if (personId == null) return null;
    return measurementsRepository.findByPerson_Id(personId).orElse(null);
  }

  public void updateMeasurements(MeasurementsEntity req) {
    MeasurementsEntity existMeasurements = this.getMeasurementsByPersonId(req.getPerson().getId());
    if (existMeasurements == null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Record does not exist");
    }
    req.setId(existMeasurements.getId());
    measurementsRepository.save(req);
  }

  public List<AgeStatResponse> getAvgHeightByAge(Integer rangeSize) {
    List<MeasurementsEntity> measurementsList = this.getAllMeasurements();

    List<AgeStatResponse> statList = measurementsList.stream()
      .collect(Collectors.groupingBy(measurements ->
        HealthUtils.catAgeRange(measurements.getPerson().getDateOfBirth(), rangeSize),
        Collectors.averagingDouble(MeasurementsEntity::getHeight)))
      .entrySet().stream()
      .map(entry -> new AgeStatResponse(entry.getKey(), df2.format(entry.getValue())))
      .collect(Collectors.toList());

      statList.sort((stat1, stat2) -> RangeUtils.getRangeFloor(stat1.getAgeRange()).compareTo(RangeUtils.getRangeFloor(stat2.getAgeRange())));
      
    return statList;
  }

  public List<AgeStatResponse> getAvgWeightByAge(Integer rangeSize) {
    List<MeasurementsEntity> measurementsList = this.getAllMeasurements();

    List<AgeStatResponse> statList = measurementsList.stream()
      .collect(Collectors.groupingBy(measurements ->
        HealthUtils.catAgeRange(measurements.getPerson().getDateOfBirth(), rangeSize),
        Collectors.averagingDouble(MeasurementsEntity::getWeight)))
      .entrySet().stream()
      .map(entry -> new AgeStatResponse(entry.getKey(), df2.format(entry.getValue())))
      .collect(Collectors.toList());

      statList.sort((stat1, stat2) -> RangeUtils.getRangeFloor(stat1.getAgeRange()).compareTo(RangeUtils.getRangeFloor(stat2.getAgeRange())));
      
    return statList;
  }

  public BMIResponse getBMIByPersonId(Integer personId) {
    try{
      MeasurementsEntity measurements = this.getMeasurementsByPersonId(personId);
      if (measurements == null){
        throw new Exception("Record does not exist");
      }
      PersonEntity person = measurements.getPerson();
      Double bmi = HealthUtils.calBMI(measurements.getHeight(), measurements.getWeight());
      bmi = Double.valueOf(df2.format(bmi));
      return new BMIResponse(person, bmi);
    } catch(Exception e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }

  }



}