package com.example.demo.controller;

import com.example.demo.model.UserMng;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // пример для получения пользователя, потом удалим метод
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        Optional<UserMng> user = userService.findById(id);
        if (user.isPresent()) {
            return user.get().toString();
        }

        return "User not found";
    }
}
