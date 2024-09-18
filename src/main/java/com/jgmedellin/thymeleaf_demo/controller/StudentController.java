package com.jgmedellin.thymeleaf_demo.controller;

import com.jgmedellin.thymeleaf_demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

  @Value("${countries}") // Injecting the list of countries from application.properties
  private List<String> countries;

  @Value("${languages}") // Injecting the list of languages from application.properties
  private List<String> languages;

  @Value("${systems}") // Injecting the list of systems from application.properties
  private List<String> systems;

  @GetMapping("/showStudentForm")
  public String showStudentForm(Model theModel) {
    Student theStudent = new Student();
    theModel.addAttribute("student", theStudent);
    theModel.addAttribute("countries", countries);
    theModel.addAttribute("languages", languages);
    theModel.addAttribute("systems", systems);
    return "student-form";
  }

  @PostMapping("/processStudentForm")
  public String processStudentForm(@ModelAttribute("student") Student theStudent) {
    System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
    return "student-registration-confirmation";
  }

}
