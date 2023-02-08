package com.gambler.mongo;

import gmongo.product.model.ProductMng;
import gmongo.product.repository.ProductRepository;
import gmongo.user.model.UserMng;
import gmongo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FillMongo implements ApplicationRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        fillUsers();
        fillProducts();
    }

    private void fillUsers() {
        userRepository.clear();

        List<UserMng> users = List.of(
                new UserMng()
                        .setId(1)
                        .setName("Oleg")
                        .setLastname("Ivanov")
                        .setLogin("oleg_ivanov56@mailingo.com")
                        .setPassword("random678"),
                new UserMng()
                        .setId(2)
                        .setName("Kolya")
                        .setLastname("Tapok")
                        .setLogin("kolya_tapok23@mailinator.com")
                        .setPassword("something978"),
                new UserMng()
                        .setId(3)
                        .setName("Vitya")
                        .setLastname("Ivansky")
                        .setLogin("viktor7687fd@mailinator.com")
                        .setPassword("check99978"));

        userRepository.insertAll(users);
    }

    private void fillProducts() {
        productRepository.clear();

        List<ProductMng> products = List.of(
                new ProductMng()
                        .setId(1)
                        .setName("Носки")
                        .setOwnerId(1),
                new ProductMng()
                        .setId(2)
                        .setName("Ноутбук")
                        .setOwnerId(1));

        productRepository.insertAll(products);
    }
}