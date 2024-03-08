package com.example.jwt_practica.repository;

import com.example.jwt_practica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUserName(String userName);
  Boolean existsByUserName(String userName);
}
