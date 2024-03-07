package com.example.jwt_practica.service;

import com.example.jwt_practica.dao.RoleDao;
import com.example.jwt_practica.dao.UserDao;
import com.example.jwt_practica.entity.Role;
import com.example.jwt_practica.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    Role adminRole = new Role();
    adminRole.setRoleDescrip("Admin role");
    adminRole.setRoleName("Admin");
    roleDao.save(adminRole);

    Role userRole = new Role();
    userRole.setRoleDescrip("Default role for newly created users");
    userRole.setRoleName("User");
    roleDao.save(userRole);

    User admin = new User();
    admin.setUserNickName("Admin1");
    admin.setUserEmail("admin@gmail.com");
    admin.setUserPassword("admin123");
    admin.setUserName("Admin");
    admin.setUserLastname("Admin");
    Set<Role> adminRoles = new HashSet<>();
    adminRoles.add(adminRole);
    admin.setUserRole(adminRoles);
    userDao.save(admin);

    User user = new User();
    user.setUserNickName("User1");
    user.setUserEmail("user@gmail.com");
    user.setUserPassword("user123");
    user.setUserName("User");
    user.setUserLastname("User");
    Set<Role> userRoles = new HashSet<>();
    userRoles.add(userRole);
    user.setUserRole(userRoles);
    userDao.save(user);
  }
}
