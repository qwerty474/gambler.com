package com.example.demo.service;

import com.example.demo.model.UserMng;

import java.util.Optional;

public interface UserService {
    Optional<UserMng> findById(Integer id);
}
