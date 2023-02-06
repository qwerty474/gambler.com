package com.gambler.mongo;

import gmongo.model.UserMng;
import gmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FillMongo implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.clear();

        // коллекция с пользователями, которые пойду в бд
        List<UserMng> users = List.of(
                new UserMng(1, "Oleg", "Ivanov", 56, "oleg_ivanov56@mailingo.com", "random678"),
                new UserMng(2, "Kolya", "Tapok", 23, "kolya_tapok23@mailinator.com", "something978"),
                new UserMng(3, "Vitya", "Ivansky", 23, "viktor7687fd@mailinator.com", "check99978"));

        userRepository.insertAll(users);
    }
}