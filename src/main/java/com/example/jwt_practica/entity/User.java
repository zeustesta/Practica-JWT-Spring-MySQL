package com.example.jwt_practica.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class User {
  @Id
  private String userNickName;
  private String userName;
  private String userLastname;
  private String userEmail;
  private String userPassword;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE",
    joinColumns = {
          @JoinColumn(name = "USER_ID")
    },
    inverseJoinColumns = {
          @JoinColumn(name = "ROLE_ID")
    }
  )
  private Set<Role> userRole;

  public String getUserNickName() {
    return userNickName;
  }
  public void setUserNickName(String userNickName) {
    this.userNickName = userNickName;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getUserLastname() {
    return userLastname;
  }
  public void setUserLastname(String userSurname) {
    this.userLastname = userSurname;
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
  public Set<Role> getUserRole() {
    return userRole;
  }
  public void setUserRole(Set<Role> userRole) {
    this.userRole = userRole;
  }
}
