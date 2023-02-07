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
                new UserMng(1, "Oleg", "Ivanov", 56),
                new UserMng(2, "Kolya", "Tapok", 23));

        userRepository.insertAll(users);
    }
}
