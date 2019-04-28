package com.example.health_rest_app.controller;

import java.util.List;

import com.example.health_rest_app.entity.MeasurementsEntity;
import com.example.health_rest_app.entity.PersonEntity;
import com.example.health_rest_app.model.AgeStatResponse;
import com.example.health_rest_app.model.BMIResponse;
import com.example.health_rest_app.service.HealthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @Autowired
  HealthService healthService;

  @PostMapping("/person")
  public void postPerson(@RequestBody PersonEntity req){
    healthService.insertPerson(req);
  }

  @GetMapping("/person")
  public List<PersonEntity> getAllPerson() {
    return healthService.getAllPerson();
  }

  @GetMapping("/person/{personId}")
  public PersonEntity getPersonById(@PathVariable Integer personId) {
    return healthService.getPersonById(personId);
  }

  @DeleteMapping("/person/{personId}")
  public void deletePersonById(@PathVariable Integer personId) {
    healthService.deletePersonById(personId);
  }

  @PostMapping("/measurements")
  public void postMeasurements(@RequestBody MeasurementsEntity req){
    healthService.insertMeasurements(req);
  }

  @GetMapping("/measurements")
  public List<MeasurementsEntity> getAllMeasurements() {
    return healthService.getAllMeasurements();
  }

  @GetMapping("/measurements/{personId}")
  public MeasurementsEntity getMeasurementsByPersonId(@PathVariable Integer personId) {
    return healthService.getMeasurementsByPersonId(personId);
  }

  @PutMapping("/measurements")
  public void putMeasurements(@RequestBody MeasurementsEntity req) {
    healthService.updateMeasurements(req);
  }

  @GetMapping("/height/age")
  public List<AgeStatResponse> getAvgHeightByAge(@RequestParam(required = false, defaultValue = "10") Integer rangeSize){
    return healthService.getAvgHeightByAge(rangeSize);
  }

  @GetMapping("/weight/age")
  public List<AgeStatResponse> getAvgWeightByAge(@RequestParam(required = false, defaultValue = "10") Integer rangeSize){
    return healthService.getAvgWeightByAge(rangeSize);
  }

  @GetMapping("/bmi/{personId}")
  public BMIResponse getBMIByPersonId(@PathVariable Integer personId) {
    return healthService.getBMIByPersonId(personId);
  }

}