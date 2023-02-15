package com.gambler.service.user.converter;

import com.gambler.service.user.model.User;
import gmongo.user.model.UserMng;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class UserConverter {

    public Optional<User> convert(Optional<UserMng> optionalUserMng) {
        if (optionalUserMng.isEmpty()) {
            return Optional.empty();
        }

        UserMng userMng = optionalUserMng.get();
        return Optional.ofNullable((new User()
                .setId(userMng.getId())
                .setName(userMng.getName())
                .setLastname(userMng.getLastname())
                .setLogin(userMng.getLogin())
                .setPassword(userMng.getPassword())
                .setRoles(Collections.singletonList(userMng.getRole()))));
    }
}
