package com.example.jwt_practica.controller;

import com.example.jwt_practica.entity.User;
import com.example.jwt_practica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @PostMapping({"/registerNewUser"})
  public User RegisterNewUser(@RequestBody User newUser) {
    return userService.RegisterNewUser(newUser);
  }
}
