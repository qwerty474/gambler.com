package com.gambler.service.user.service;


import com.gambler.service.user.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> findById(Integer id);

    Optional<User> findByLogin(String login);
}
