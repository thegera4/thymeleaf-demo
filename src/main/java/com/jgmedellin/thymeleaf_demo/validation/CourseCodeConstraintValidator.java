package com.jgmedellin.thymeleaf_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

  private String coursePrefix;

  @Override
  public void initialize(CourseCode theCourseCode) {
    coursePrefix = theCourseCode.value(); //assign the value passed in from our annotation
  }

  @Override
  public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
    boolean result;
    if(theCode != null) {
      result = theCode.startsWith(coursePrefix); //check if the course code starts with the course prefix
    } else {
      result = true; //if the course code is null, return true, meaning it is valid
    }
    return result;
  }
}
