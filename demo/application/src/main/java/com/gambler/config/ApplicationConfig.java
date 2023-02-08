package com.gambler.config;

import gmongo.product.repository.ProductMngRepository;
import gmongo.product.repository.ProductMngRepositoryImpl;
import gmongo.user.repository.UserMngRepository;
import gmongo.user.repository.UserMngRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserMngRepository userRepository(MongoTemplate mongoTemplate) {
        return new UserMngRepositoryImpl(mongoTemplate);
    }

    @Bean
    public ProductMngRepository productRepository(MongoTemplate mongoTemplate) {
        return new ProductMngRepositoryImpl(mongoTemplate);
    }
}
