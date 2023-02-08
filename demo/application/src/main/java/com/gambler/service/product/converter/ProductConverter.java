package com.gambler.service.product.converter;

import com.gambler.service.product.model.Product;
import gmongo.product.model.ProductMng;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public Optional<Product> convert(Optional<ProductMng> optionalProductMng) {
        if (optionalProductMng.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(convert(optionalProductMng.get()));
    }

    public List<Product> convert(List<ProductMng> products) {
        return products.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private Product convert(ProductMng productMng) {
        return new Product()
                .setId(productMng.getId())
                .setName(productMng.getName())
                .setOwnerId(productMng.getOwnerId());
    }
}
