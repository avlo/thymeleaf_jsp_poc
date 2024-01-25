package com.example.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@Controller
public class LoginController {

  @GetMapping(value="/login")
  public String showLoginPage(ModelMap model){
    return "jsp/login";
  }

  @GetMapping(value="/hello")
  public String hello(ModelMap model){
    return "thymeleaf/hello";
  }
}