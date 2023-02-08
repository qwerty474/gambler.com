package com.gambler.controller.user.convert;

import com.gambler.controller.user.model.UserDto;
import com.gambler.service.product.model.Product;
import com.gambler.service.user.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConvert {

    public UserDto convert(User user, List<Product> products) {
        return new UserDto()
                .setId(user.getId())
                .setLastname(user.getLastname())
                .setName(user.getName())
                .setProducts(products.stream()
                        .map(this::convertProduct)
                        .collect(Collectors.toList()));
    }

    private UserDto.UserProductDto convertProduct(Product product) {
        return new UserDto.UserProductDto()
                .setId(product.getId())
                .setName(product.getName());
    }
}
