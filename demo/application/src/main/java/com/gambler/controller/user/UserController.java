package com.gambler.controller.user;

import com.gambler.controller.user.model.UserDto;
import com.gambler.error.exception.BackendException;
import com.gambler.error.exception.CabinetError;
import com.gambler.service.product.model.Product;
import com.gambler.service.user.model.User;
import com.gambler.service.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // пример для получения пользователя, потом удалим метод
    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserDto(userId);
    }

}
