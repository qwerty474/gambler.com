package com.gambler.config;

import gmongo.product.repository.ProductRepository;
import gmongo.product.repository.ProductRepositoryImpl;
import gmongo.user.repository.UserRepository;
import gmongo.user.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserRepository userRepository(MongoTemplate mongoTemplate) {
        return new UserRepositoryImpl(mongoTemplate);
    }

    @Bean
    public ProductRepository productRepository(MongoTemplate mongoTemplate) {
        return new ProductRepositoryImpl(mongoTemplate);
    }
}
