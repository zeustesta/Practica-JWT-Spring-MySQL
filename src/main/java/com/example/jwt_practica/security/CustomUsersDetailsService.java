package com.example.jwt_practica.security;

import com.example.jwt_practica.model.Role;
import com.example.jwt_practica.model.User;
import com.example.jwt_practica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUsersDetailsService implements UserDetailsService {
  private IUserRepository userRep;
  @Autowired
  public CustomUsersDetailsService(IUserRepository userRep) {
    this.userRep = userRep;
  }
  public Collection<GrantedAuthority> mapToAuthorities(List<Role> roleList) {
   return roleList.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
  }
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userRep.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User email not found"));
    return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), mapToAuthorities(user.getUserRole()));
  }
}
