package com.example.jwt_practica.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
  private static final String GET = "GET";
  private static final String POST = "POST";
  private static final String DELETE = "DELETE";
  private static final String PUT = "PUT";
  public WebMvcConfigurer CorsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
          .allowedMethods(GET, POST, PUT, DELETE)
          .allowedHeaders("*")
          .allowedOriginPatterns("*")
          .allowCredentials(true);
      }
    };
  }
}