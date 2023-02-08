package com.gambler.service.user.repository;

import com.gambler.service.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Integer id);

    Optional<User> findByLogin(String login);
}
