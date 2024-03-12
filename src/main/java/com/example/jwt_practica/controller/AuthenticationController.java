package com.example.jwt_practica.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt_practica.model.AuthenticationRequest;
import com.example.jwt_practica.model.AuthenticationResponse;
import com.example.jwt_practica.model.RegisterRequest;
import com.example.jwt_practica.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }
  
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }
}
