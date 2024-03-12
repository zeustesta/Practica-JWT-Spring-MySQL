package com.example.jwt_practica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.jwt_practica.model.Role;
import com.example.jwt_practica.model.User;
import com.example.jwt_practica.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  @Autowired
  private final IUserRepository userDao;
  private final PasswordEncoder passwordEncoder;

  @SuppressWarnings("null")
  public User RegisterNewUser(User newUser) {
    return userDao.save(newUser);
  }

  public User FindByEmail(String email) {
    return userDao.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }

  public boolean ExistsByEmail(String email) {
    return userDao.existsByEmail(email);
  }

  public void InitRolesAndUsers() {
    User admin = new User("Admin", "Admin", "admin@gmail.com", passwordEncoder.encode("admin123"), Role.ADMIN);
    userDao.save(admin);

    User user = new User("User", "User", "user@gmail.com", passwordEncoder.encode("user123"), Role.USER);
    userDao.save(user);
  }
}
