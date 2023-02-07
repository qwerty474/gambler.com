package com.gambler.entities;

import gmongo.model.UserMng;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUser implements UserDetails {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String login;
    private String password;

    public MyUser(Integer id, String name, String surname, Integer age, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public MyUser(UserMng userMng) {
        this.id = userMng.getId();
        this.name = userMng.getName();
        this.surname = userMng.getSurname();
        this.age = userMng.getAge();
        this.login = userMng.getLogin();
        this.password = userMng.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //права добавим потом
        return null;
    }

    @Override
    public String getPassword() {
        return password;
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
