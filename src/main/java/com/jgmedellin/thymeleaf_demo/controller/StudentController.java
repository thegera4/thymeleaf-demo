package com.jgmedellin.thymeleaf_demo.controller;

import com.jgmedellin.thymeleaf_demo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

  // Method to add the lists to the model instead of repeating code
  private void addListsToModel(Model theModel) {
    theModel.addAttribute("countries", countries);
    theModel.addAttribute("languages", languages);
    theModel.addAttribute("systems", systems);
  }

  // InitBinder to convert trim input strings. This method will run before any web request comes in to the controller.
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/showStudentForm")
  public String showStudentForm(Model theModel) {
    Student theStudent = new Student();
    theModel.addAttribute("student", theStudent);
    addListsToModel(theModel);
    return "student-form";
  }

  @PostMapping("/processStudentForm")
  public String processStudentForm(
          @Valid  // Validate the Student object
          @ModelAttribute("student") Student theStudent, // Bind the form data to the Student object
          BindingResult theBindingResult, // BindingResult object to store the validation result
          Model theModel // Model object needed to re-render the form in case of validation errors
  ) {
    if(theBindingResult.hasErrors()) {
      addListsToModel(theModel); // we add the lists back to the model to re-render the form
      return "student-form";
    } else {
      return "student-registration-confirmation";
    }
  }

}