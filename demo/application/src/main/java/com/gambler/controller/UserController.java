package com.gambler.controller;

import com.gambler.error.exception.BackendException;
import com.gambler.error.exception.CabinetError;
import com.gambler.service.product.model.Product;
import com.gambler.service.product.service.ProductService;
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
    private final ProductService productService;

    // пример для получения пользователя, потом удалим метод
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }

        throw new BackendException(CabinetError.NOT_FOUND);
    }

    @GetMapping("/{userId}/product")
    public List<Product> getProducts(@PathVariable("userId") Integer userId) {
        return productService.findByOwnerId(userId);
    }

    @GetMapping("/{id}/product/{productId}")
    public Product getProduct(@PathVariable("id") Integer userId,
                              @PathVariable("productId") Integer productId) {
        return productService.findByProductIdAndOwnerId(productId, userId).get();
    }
}
