package com.example.jwt_practica.service;

import com.example.jwt_practica.controller.UserController;
import com.example.jwt_practica.model.AuthenticationRequest;
import com.example.jwt_practica.model.AuthenticationResponse;
import com.example.jwt_practica.model.RegisterRequest;
import com.example.jwt_practica.model.Role;
import com.example.jwt_practica.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserController userController;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authManager;

  public AuthenticationResponse register(RegisterRequest request) {
    User newUser = new User(
      request.getFirstname(), 
      request.getLastname(), 
      request.getEmail(), 
      passwordEncoder.encode(request.getPassword()), 
      Role.USER
    );
    userController.RegisterNewUser(newUser);
    
    final String jwt = jwtService.generateToken(newUser);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );
    User user = userController.FindByEmail(request.getEmail());
    final String jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
    }
}
