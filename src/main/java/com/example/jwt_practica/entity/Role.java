package com.example.jwt_practica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Role {
  @Id
  private String roleName;
  private String roleDescrip;

  public String getRoleName() {
    return roleName;
  }
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
  public String getRoleDescrip() {
    return roleDescrip;
  }
  public void setRoleDescrip(String roleDescrip) {
    this.roleDescrip = roleDescrip;
  }
}
