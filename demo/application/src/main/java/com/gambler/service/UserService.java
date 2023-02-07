package com.gambler.service;


import com.gambler.entities.MyUser;
import gmongo.model.UserMng;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<UserMng> findById(Integer id);

    Optional<MyUser> findByLogin(String login);
}
