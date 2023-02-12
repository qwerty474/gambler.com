package com.gambler.service.user.convert;

import com.gambler.service.user.converter.UserConverter;
import com.gambler.service.user.model.User;
import gmongo.user.model.UserMng;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class UserConvertTest {

    @InjectMocks
    private UserConverter userConverter;

    @Test
    void convert_success() {
        UserMng userMng = new UserMng()
                .setId(1)
                .setName("name")
                .setLastname("lastname")
                .setLogin("login")
                .setPassword("password")
                .setRole("role");

        Optional<User> expected = Optional.of(new User()
                .setId(1)
                .setName("name")
                .setLastname("lastname")
                .setLogin("login")
                .setPassword("password")
                .setRole("role"));

        Optional<User> actual = userConverter.convert(Optional.of(userMng));

        assertEquals(expected, actual);
    }

    @Test
    void convert_whereIsEmpty_thenReturnEmptyOptional() {
        Optional<User> actual = userConverter.convert(Optional.empty());
        assertTrue(actual.isEmpty());
    }

}
