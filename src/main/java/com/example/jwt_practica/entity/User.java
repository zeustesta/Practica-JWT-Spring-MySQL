package com.example.jwt_practica.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class User {
  @Id
  private UUID userID;
  private String userName;
  private String userSurname;
  private String userEmail;
  private String userPassword;
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "roleId")
  private Role userRole;

  public UUID getUserID() {
    return userID;
  }

  public void setUserID(UUID userID) {
    this.userID = userID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserSurname() {
    return userSurname;
  }

  public void setUserSurname(String userSurname) {
    this.userSurname = userSurname;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Role getUserRole() {
    return userRole;
  }

  public void setUserRole(Role userRole) {
    this.userRole = userRole;
  }
}
