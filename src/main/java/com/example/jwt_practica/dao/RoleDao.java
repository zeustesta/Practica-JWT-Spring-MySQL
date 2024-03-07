package com.example.jwt_practica.dao;

import com.example.jwt_practica.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleDao extends CrudRepository<Role, UUID> {

}
