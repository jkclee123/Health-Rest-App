package com.example.health_rest_app.repository;

import java.util.Optional;

import com.example.health_rest_app.entity.MeasurementsEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends CrudRepository<MeasurementsEntity, Integer> {

  Optional<MeasurementsEntity> findByPerson_Id(Integer personId);

}