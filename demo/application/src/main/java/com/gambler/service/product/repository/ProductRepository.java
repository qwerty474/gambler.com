package com.gambler.service.product.repository;

import com.gambler.service.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findByOwnerId(Integer ownerId);

    Optional<Product> findByProductIdAndOwnerId(Integer productId, Integer ownerId);
}
