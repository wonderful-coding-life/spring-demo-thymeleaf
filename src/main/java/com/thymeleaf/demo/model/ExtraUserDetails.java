package com.thymeleaf.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Data
@Builder
public class ExtraUserDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    private String password;
    private String username;
    private String displayName;
    private String profileImage;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
