package com.example.jwt_practica.auth;

import com.example.jwt_practica.model.Role;
import com.example.jwt_practica.model.User;
import com.example.jwt_practica.repository.IUserRepository;
import com.example.jwt_practica.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final IUserRepository userRep;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authManager;
  public AuthenticationResponse register(RegisterRequest request) {
    User newUser = new User();
    newUser.setFirstName(request.getFirstname());
    newUser.setLastName(request.getLastname());
    newUser.setEmail(request.getEmail());
    newUser.setPassword(passwordEncoder.encode(request.getPassword()));
    newUser.setRole(Role.USER);
    userRep.save(newUser);
    final String jwt = jwtService.generateToken(newUser);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );
    User user = userRep.findByEmail(request.getEmail()).orElseThrow();
    final String jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
    }
}
