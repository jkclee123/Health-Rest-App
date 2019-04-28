package com.example.health_rest_app.utils;

public class RangeUtils{

  /**
   * <p>Round down <code>value</code> to nearest range floor</p>
   * 
   * @param value
   * @param rangeSize
   * @return nearest range floor of value
   * @throws IllegalArgumentException if given <code>value</code> or <code>rangeSize</code> is null
   */
  public static Integer roundToRangeFloor(Integer value, Integer rangeSize){
    if (value == null || rangeSize == null){
      throw new IllegalArgumentException("Value and Step must not be null");
    }
    return value / rangeSize * rangeSize;
  }

  /**
   * <p>Get Floor of given <code>range</code></p>
   * <pre>if (range = "40") -> returns 40</pre>
   * <pre>if (range = "40-49") -> returns 40</pre>
   * 
   * @param range
   * @return floor of range
   * @throws IllegalArgumentException if given <code>dob</code> or <code>step</code> is null
   */
  public static Integer getRangeFloor(String range){
    if (range == null){
      throw new IllegalArgumentException("Age Range must not be null");
    }
    if (range.contains("-")){
      String rangeFloor = range.split("\\-")[0];
      return Integer.valueOf(rangeFloor);
    } else{
      return Integer.valueOf(range);
    }
  }

}