package com.example.jwt_practica.repository;

import com.example.jwt_practica.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByRoleName(String roleName);
}
