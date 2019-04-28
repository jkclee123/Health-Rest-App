package com.example.health_rest_app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "person")
public class PersonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;


  public PersonEntity() {
  }

  public PersonEntity(Integer id){
    this.id = id;
  }

  public PersonEntity(Integer id, String name, LocalDate dateOfBirth) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public PersonEntity id(Integer id) {
    this.id = id;
    return this;
  }

  public PersonEntity name(String name) {
    this.name = name;
    return this;
  }

  public PersonEntity dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", dateOfBirth='" + getDateOfBirth() + "'" +
      "}";
  }
  

}