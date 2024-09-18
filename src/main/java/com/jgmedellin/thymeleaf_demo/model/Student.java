package com.jgmedellin.thymeleaf_demo.model;

import com.jgmedellin.thymeleaf_demo.validation.CourseCode;
import jakarta.validation.constraints.*;

import java.util.List;

public class Student {

  @NotNull(message = "name is required") // Validation rule
  @Size(min = 1, message = "name should be at least 1 character") // Validation rule
  private String firstName;

  @NotNull(message = "lastname is required")
  @Size(min = 2, message = "lastname should be at least 2 characters")
  private String lastName;

  @NotNull(message = "age is required")
  @Min(value = 18, message = "age should be at least 18")
  @Max(value = 90, message = "age should be less than 90")
  private Integer age;

  private String country;

  @Pattern(regexp = "^[0-9]{5}", message = "postal code should be 5 digits")
  private String postalCode;

  @CourseCode // Custom validation rule
  private String courseCode;

  private String favoriteLanguage;

  private List<String> favoriteSystems;

  public Student() {
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  public List<String> getFavoriteSystems() {
    return favoriteSystems;
  }

  public void setFavoriteSystems(List<String> favoriteSystems) {
    this.favoriteSystems = favoriteSystems;
  }

}
