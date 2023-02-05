package com.gambler.controller;

import com.gambler.error.exception.BackendException;
import com.gambler.error.exception.CabinetError;
import com.gambler.service.UserService;
import gmongo.model.UserMng;
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

        throw new BackendException(CabinetError.NOT_FOUND);
    }
}
