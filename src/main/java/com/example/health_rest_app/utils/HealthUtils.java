package com.example.health_rest_app.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HealthUtils {

  /**
   * <p>Calculates Body Mass Index(BMI) with given <code>height</code> and <code>weight</code></p>
   * 
   * @param height - in cm
   * @param weight - in kg
   * @return calculated bmi
   * @throws IllegalArgumentException if given <code>height</code> or <code>weight</code> is null
   */
  public static Double calBMI(Double height, Double weight) {
    if (height == null || weight == null){
      throw new IllegalArgumentException("Height and Weight must not be null");
    }
    return weight / height / height * 100 * 100;
  }

  /**
   * <p>Categorize <code>dob</code> into age range of size <code>rangeSize</code></p>
   * <pre>if (age = 41, rangeSize = 1) -> returns 41</pre>
   * <pre>if (age = 41, rangeSize = 3) -> returns 39-41</pre>
   * <pre>if (age = 41, rangeSize = 10) -> returns 40-49</pre>
   * 
   * @param dob
   * @param rangeSize
   * @return belonged age range
   * @throws IllegalArgumentException if given <code>dob</code> or <code>rangeSize</code> is null
   */
  public static String catAgeRange(LocalDate dob, Integer rangeSize) {
    if (dob == null || rangeSize == null){
      throw new IllegalArgumentException("DOB and Step must not be null");
    }
    Integer yearDiff = Math.toIntExact(dob.until(LocalDate.now(), ChronoUnit.YEARS));
    Integer rangeFloor = RangeUtils.roundToRangeFloor(yearDiff, rangeSize);
    Integer rangeCeil = rangeFloor + rangeSize - 1;
    String ageRange = "";
    if (rangeFloor == rangeCeil){
      ageRange = String.valueOf(rangeFloor);
    } else{
      ageRange = String.format("%d-%d", rangeFloor, rangeCeil);
    }
    return ageRange;
  }

}