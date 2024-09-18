package com.jgmedellin.thymeleaf_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // Custom class that contains business validation logic
@Target({ElementType.METHOD, ElementType.FIELD}) // Where we can apply this annotation to a method or field
@Retention(RetentionPolicy.RUNTIME) // How long the annotation will be stored
public @interface CourseCode {

  // Define default course code
  public String value() default "COU";

  // Define default error message
  public String message() default "must start with COU";

  // Define default groups (groups provide custom validation ordering)
  public Class<?>[] groups() default {};

  // Define default payloads (payload provide custom details about validation failure)
  public Class<? extends Payload>[] payload() default {};

}
