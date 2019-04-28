package com.example.health_rest_app.repository;

import com.example.health_rest_app.entity.PersonEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

}