package com.example.jwt_practica.service;

import com.example.jwt_practica.dao.RoleDao;
import com.example.jwt_practica.dao.UserDao;
import com.example.jwt_practica.entity.Role;
import com.example.jwt_practica.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;
  @Autowired
  private RoleDao roleDao;

  public User RegisterNewUser(User newUser) {
    return userDao.save(newUser);
  }

  public void InitRolesAndUsers() {
    Role adminRole = new Role(1L, "ADMIN");
    roleDao.save(adminRole);

    Role userRole = new Role(2L, "USER");
    roleDao.save(userRole);

    List<Role> adminRoles = new ArrayList<>();
    adminRoles.add(adminRole);
    User admin = new User(1L, "Admin", "Admin", "admin@gmail.com", "admin123", adminRoles);
    userDao.save(admin);

    List<Role> userRoles = new ArrayList<>();
    userRoles.add(userRole);
    User user = new User(2L, "User", "User", "user@gmail.com", "user123", userRoles);
    userDao.save(user);
  }
}
