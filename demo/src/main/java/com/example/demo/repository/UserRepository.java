package com.example.demo.repository;

import com.example.demo.model.UserMng;

import java.util.Optional;

public interface UserRepository {
    Optional<UserMng> findById(Integer id);
}
