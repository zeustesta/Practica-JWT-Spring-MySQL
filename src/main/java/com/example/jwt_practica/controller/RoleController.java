package com.example.jwt_practica.controller;

import com.example.jwt_practica.entity.Role;
import com.example.jwt_practica.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
  @Autowired
  private RoleService roleService;
  @PostMapping({"/createNewRol"})
  public Role CreateNewRol(@RequestBody Role role) {
    return roleService.CreateNewRole(role);
  }
}
