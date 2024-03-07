package com.example.jwt_practica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long userId;
  private String userName;
  private String userLastname;
  private String userEmail;
  private String userPassword;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "USER_ROLE", joinColumns =
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
      inverseJoinColumns =
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
  )
  private List<Role> userRole = new ArrayList<>();
}
