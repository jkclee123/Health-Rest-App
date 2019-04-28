package com.example.health_rest_app.model;

public class AgeStatResponse{

  private String ageRange;

  private String avgValue;

  public AgeStatResponse() {
  }

  public AgeStatResponse(String ageRange, String avgValue) {
    this.ageRange = ageRange;
    this.avgValue = avgValue;
  }

  public String getAgeRange() {
    return this.ageRange;
  }

  public void setAgeRange(String ageRange) {
    this.ageRange = ageRange;
  }

  public String getAvgValue() {
    return this.avgValue;
  }

  public void setAvgValue(String avgValue) {
    this.avgValue = avgValue;
  }

  public AgeStatResponse ageRange(String ageRange) {
    this.ageRange = ageRange;
    return this;
  }

  public AgeStatResponse avgValue(String avgValue) {
    this.avgValue = avgValue;
    return this;
  }

  @Override
  public String toString() {
    return "{" +
      " ageRange='" + getAgeRange() + "'" +
      ", avgValue='" + getAvgValue() + "'" +
      "}";
  }
  
}
