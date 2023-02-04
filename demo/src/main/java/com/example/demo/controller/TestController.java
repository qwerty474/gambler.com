package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String test() {
        return "Hello Spring!";
    }

    // пример для получения пользователя, потом удалим метод
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().toString();
        }

        return "User not found";
    }

}
