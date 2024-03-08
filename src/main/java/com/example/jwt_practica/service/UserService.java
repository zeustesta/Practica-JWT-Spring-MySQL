package com.example.jwt_practica.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
//  @Autowired
//  private UserDao userDao;
//  @Autowired
//  private RoleDao roleDao;
//
//  public User RegisterNewUser(User newUser) {
//    return userDao.save(newUser);
//  }
//
//  public void InitRolesAndUsers() {
//    Role adminRole = new Role(1L, "ADMIN");
//    roleDao.save(adminRole);
//
//    Role userRole = new Role(2L, "USER");
//    roleDao.save(userRole);
//
//    List<Role> adminRoles = new ArrayList<>();
//    adminRoles.add(adminRole);
//    User admin = new User(1L, "Admin", "Admin", "admin@gmail.com", "admin123", adminRoles);
//    userDao.save(admin);
//
//    List<Role> userRoles = new ArrayList<>();
//    userRoles.add(userRole);
//    User user = new User(2L, "User", "User", "user@gmail.com", "user123", userRoles);
//    userDao.save(user);
//  }
}
