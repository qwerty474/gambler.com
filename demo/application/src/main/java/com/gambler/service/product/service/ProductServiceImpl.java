package com.gambler.service.product.service;

import com.gambler.service.product.converter.ProductConverter;
import com.gambler.service.product.model.Product;
import gmongo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    @Override
    public List<Product> findByOwnerId(Integer ownerId) {
        return productConverter.convert(productRepository.findProductByOwnerId(ownerId));
    }

    @Override
    public Optional<Product> findByProductIdAndOwnerId(Integer productId, Integer ownerId) {
        return productConverter.convert(
                productRepository.findProductByProductIdAndOwnerId(productId, ownerId));
    }
}
