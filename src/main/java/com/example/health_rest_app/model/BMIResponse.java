package com.example.health_rest_app.model;

import com.example.health_rest_app.entity.PersonEntity;

public class BMIResponse{

  private PersonEntity person;

  private Double bmi;


  public BMIResponse() {
  }

  public BMIResponse(PersonEntity person, Double bmi) {
    this.person = person;
    this.bmi = bmi;
  }

  public PersonEntity getPerson() {
    return this.person;
  }

  public void setPerson(PersonEntity person) {
    this.person = person;
  }

  public Double getBmi() {
    return this.bmi;
  }

  public void setBmi(Double bmi) {
    this.bmi = bmi;
  }

  public BMIResponse person(PersonEntity person) {
    this.person = person;
    return this;
  }

  public BMIResponse bmi(Double bmi) {
    this.bmi = bmi;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " person='" + getPerson() + "'" +
      ", bmi='" + getBmi() + "'" +
      "}";
  }


}