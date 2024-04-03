package com.example.student.module.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "login")
public class SecurityProperties {
    private String username;
    private String password;
}
