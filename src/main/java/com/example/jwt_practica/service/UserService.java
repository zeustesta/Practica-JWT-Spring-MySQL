package com.example.jwt_practica.service;

import com.example.jwt_practica.dao.UserDao;
import com.example.jwt_practica.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  public User RegisterNewUser(User newUser) {
    return userDao.save(newUser);
  }
}
