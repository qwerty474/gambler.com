package com.gambler.service.user.model;

import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserRoles implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return null;
    }

    public List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            if (role.equals("ROLE_ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            if (role.equals("ROLE_SELLER")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_BUYER"));
            }
            if (role.equals("ROLE_BUYER")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_BUYER"));
            }
        }
        return authorities;
    }
}
