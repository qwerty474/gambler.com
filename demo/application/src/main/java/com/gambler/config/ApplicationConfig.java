package com.gambler.config;

import gmongo.repository.UserRepository;
import gmongo.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    public UserRepository userRepository(MongoTemplate mongoTemplate) {
        return new UserRepositoryImpl(mongoTemplate);
    }
}
