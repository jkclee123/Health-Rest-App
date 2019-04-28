package com.example.health_rest_app.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "measurements")
public class MeasurementsEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Double height;

  private Double weight;

  @OneToOne
  @JoinColumn(name = "person_id")
  private PersonEntity person;


  public MeasurementsEntity() {
  }

  public MeasurementsEntity(Integer id, Double height, Double weight, PersonEntity person) {
    this.id = id;
    this.height = height;
    this.weight = weight;
    this.person = person;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getHeight() {
    return this.height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWeight() {
    return this.weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public PersonEntity getPerson() {
    return this.person;
  }

  public void setPerson(PersonEntity person) {
    this.person = person;
  }

  public void setPersonId(Integer personId){
    this.person = new PersonEntity(personId);
  }

  public MeasurementsEntity id(Integer id) {
    this.id = id;
    return this;
  }

  public MeasurementsEntity height(Double height) {
    this.height = height;
    return this;
  }

  public MeasurementsEntity weight(Double weight) {
    this.weight = weight;
    return this;
  }

  public MeasurementsEntity person(PersonEntity person) {
    this.person = person;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", height='" + getHeight() + "'" +
      ", weight='" + getWeight() + "'" +
      ", person='" + getPerson() + "'" +
      "}";
  }



}