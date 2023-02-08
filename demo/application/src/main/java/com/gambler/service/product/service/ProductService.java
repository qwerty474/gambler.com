package com.gambler.service.product.service;

import com.gambler.service.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findByOwnerId(Integer ownerId);

    Optional<Product> findByProductIdAndOwnerId(Integer productId, Integer ownerId);
}
