package com.example.controller;

import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
  private final LoginService service;

  @Autowired
  public LoginController(LoginService service) {
    this.service = service;
  }

  @GetMapping(value="/login")
  public String showLoginPage(ModelMap model){
    return "login";
  }

  @PostMapping(value="/login")
  public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

    boolean isValidUser = service.validateUser(name, password);

    if (!isValidUser) {
      model.put("errorMessage", "Invalid Credentials");
      return "login";
    }

    model.put("name", name);
    model.put("password", password);

    return "welcome";
  }
}