package com.thymeleaf.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collection;

@Configuration
public class SecurityConfig {
    //@Bean
    public UserDetailsService userDetailsServiceWithInMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("user1")
                        .password("{noop}pass1")
                        .roles("EMPLOYEE", "PRODUCT")
                        .build(),
                User.builder()
                        .username("user2")
                        .password("{noop}pass2")
                        .roles("EMPLOYEE")
                        .build(),
                User.builder()
                        .username("user3")
                        .password("{noop}pass3")
                        .build()
        );
    }

    // not tested
    //@Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT * FROM users WHERE username=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT * FROM authorities WHERE username=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> {
            request
                    .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/image/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/employee/**")).hasAuthority("ROLE_EMPLOYEE")
                    .requestMatchers(new AntPathRequestMatcher("/product/**")).hasAuthority("ROLE_PRODUCT")
                    .anyRequest().permitAll();
        });
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    };
}
