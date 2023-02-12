package com.gambler.service.user.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public class User implements UserDetails {
    private Integer id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(this.role));
        return authList;
    }

    public List<String> getRoles(String role) {

        List<String> roles = new ArrayList<String>();
        if (role.equals("ROLE_ADMIN")) {
            roles.add("ROLE_ADMIN");
        } else if (role.equals("ROLE_SELLER")) {
            roles.add("ROLE_SELLER");
            roles.add("ROLE_BUYER");
        } else if (role.equals("ROLE_BUYER")) {
            roles.add("ROLE_BUYER");
        }
        return roles;
    }

    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
