package com.gambler.service.product.repository;

import com.gambler.service.product.converter.ProductConverter;
import com.gambler.service.product.model.Product;
import gmongo.product.repository.ProductMngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductConverter productConverter;
    private final ProductMngRepository productMngRepository;

    @Override
    public List<Product> findByOwnerId(Integer ownerId) {
        return productConverter.convert(productMngRepository.findProductByOwnerId(ownerId));
    }

    @Override
    public Optional<Product> findByProductIdAndOwnerId(Integer productId, Integer ownerId) {
        return productConverter.convert(
                productMngRepository.findProductByProductIdAndOwnerId(productId, ownerId));
    }
}
