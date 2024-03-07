package com.example.jwt_practica.controller;

import com.example.jwt_practica.entity.User;
import com.example.jwt_practica.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @PostConstruct
  public void InitRolesAndUsers(){
    userService.InitRolesAndUsers();
  }
  @PostMapping({"/registerNewUser"})
  public User RegisterNewUser(@RequestBody User newUser) {
    return userService.RegisterNewUser(newUser);
  }

  @GetMapping({"/forAdmin"})
  public String ForAdmin() {
    return "This URL is only accessible to Admins";
  }
  @GetMapping({"/forUser"})
  public String ForUser() {
    return "This URL is only accessible to Users";
  }
}
