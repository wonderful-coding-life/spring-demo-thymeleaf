package com.thymeleaf.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("user1")
                        .password("{noop}pass1")
                        .authorities("ROLE_EMPLOYEE", "ROLE_PRODUCT")
                        .build(),
                User.builder()
                        .username("user2")
                        .password("{noop}pass2")
                        .authorities("ROLE_EMPLOYEE")
                        .build(),
                User.builder()
                        .username("user3")
                        .password("{noop}pass3")
                        .build()
        );
    }
}
