package com.example.jwt_practica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ROLE_ID")
  private Long roleId;
  @Column(name = "ROLE_NAME")
  private String roleName;
}
