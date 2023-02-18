package com.gambler.mongo;

import gmongo.product.model.ProductMng;
import gmongo.product.repository.ProductMngRepository;
import gmongo.user.model.UserMng;
import gmongo.user.repository.UserMngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test")
@RequiredArgsConstructor
public class FillMongo implements ApplicationRunner {

    private final UserMngRepository userMngRepository;
    private final ProductMngRepository productMngRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        fillUsers();
        fillProducts();
    }

    private void fillUsers() {
        userMngRepository.clear();

        List<UserMng> users = List.of(
                new UserMng()
                        .setId(1)
                        .setName("Oleg")
                        .setLastname("Ivanov")
                        .setLogin("test")
                        .setPassword(passwordEncoder.encode("test")),
                new UserMng()
                        .setId(2)
                        .setName("Kolya")
                        .setLastname("Tapok")
                        .setLogin("kolya_tapok23@mailinator.com")
                        .setPassword(passwordEncoder.encode("something978")),
                new UserMng()
                        .setId(3)
                        .setName("Vitya")
                        .setLastname("Ivansky")
                        .setLogin("viktor7687fd@mailinator.com")
                        .setPassword(passwordEncoder.encode("check99978")));

        userMngRepository.insertAll(users);
    }

    private void fillProducts() {
        productMngRepository.clear();

        List<ProductMng> products = List.of(
                new ProductMng()
                        .setId(1)
                        .setName("Носки")
                        .setOwnerId(1),
                new ProductMng()
                        .setId(2)
                        .setName("Ноутбук")
                        .setOwnerId(1));

        productMngRepository.insertAll(products);
    }
}