package com.jgmedellin.thymeleaf_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

  @GetMapping("/hello")
  public String sayHello(Model theModel) {
    theModel.addAttribute("theDate", new java.util.Date());
    return "helloworld";
  }

  @GetMapping("/showForm")
  public String showForm() {
    return "student-form";
  }

  @RequestMapping("/processForm")
  public String processForm() {
    return "student-confirmation";
  }

  @RequestMapping("/processFormV2") // RequestMapping allows us to use request params
  public String letsShoutDude(
          HttpServletRequest request,  // HttpServletRequest allows us to get form data (thymeleaf method)
          Model model // Model allows us to send data to the view
  ) {
    // read the request parameter from the HTML form
    String theName = request.getParameter("studentName");

    // convert the data to all caps
    theName = theName.toUpperCase();

    // create the message
    String result = "Yo! " + theName;

    // add message to the model
    model.addAttribute("message", result);

    return "student-confirmationV2";
  }

  @RequestMapping("/processFormV3")
  public String letsShoutDude(
          @RequestParam("studentName") String theName, // @RequestParam allows us to get the param (spring method)
          Model model // Model allows us to send data to the view
  ) {
    // convert the data to all caps
    theName = theName.toUpperCase();

    // create the message
    String result = "Yo spring method! " + theName;

    // add message to the model
    model.addAttribute("message", result);

    return "student-confirmationV2";
  }
  
}
