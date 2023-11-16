package com.thymeleaf.demo.config;

import com.thymeleaf.demo.model.ExtraUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
public class ExtraUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ExtraUserDetails.builder()
                .username(username)
                .password("$2a$12$GByM3ieI3XW7EEwJnKP/HO/nRnOQxCbC7py/G7x.nGd1GJjsQzXZS") // 1234
                .displayName("홍길동(" + username + ")")
                .profileImage("http://www.naver.com/spiderman.png")
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true).build();
    }
}
