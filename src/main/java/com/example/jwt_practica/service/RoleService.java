package com.example.jwt_practica.service;

import com.example.jwt_practica.dao.RoleDao;
import com.example.jwt_practica.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  @Autowired
  private RoleDao roleDao;

  public Role CreateNewRole(Role role) {
    return roleDao.save(role);
  }
}
