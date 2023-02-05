package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    /**
     * Ищет пользователя в бд, по его id
     */
    Optional<User> findById(Integer id);

    /**
     * Очищает коллекцию в бд, если ее нет, то создаст
     */
    void clear();

    /**
     * Добавляет в бд всех пользователей
     */
    void insertAll(List<User> users);
}
