package com.example.demo.config;

import com.example.demo.model.UserMng;
import com.example.demo.repository.UserRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;

import java.util.List;

@ChangeUnit(id = "database-change-log", order = "1", author = "DatabaseChangeLog", runAlways = true)
@RequiredArgsConstructor
public class DatabaseChangeLog {

    private final UserRepository userRepository;

    @Execution
    public void changeSet() {
        userRepository.clear();

        // коллекция с пользователями, которые пойду в бд
        List<UserMng> users = List.of(
                new UserMng(1, "Oleg", "Ivanov", 56),
                new UserMng(2, "Kolya", "Tapok", 23));

        userRepository.insertAll(users);
    }

    @RollbackExecution
    public void rollback() {
        //По контракту Mongock метод с @RollbackExecution должен быть поэтому он тут
        //По хорошему нужно добавить rollback
        //Но скорее всего ChangeLog будет использоваться только в тестовых профилях
    }
}
