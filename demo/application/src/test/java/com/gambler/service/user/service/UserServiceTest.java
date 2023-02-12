package com.gambler.service.user.service;

import com.gambler.controller.user.convert.UserDtoConvert;
import com.gambler.controller.user.model.UserDto;
import com.gambler.service.product.model.Product;
import com.gambler.service.product.repository.ProductRepository;
import com.gambler.service.user.model.User;
import com.gambler.service.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static final String USERNAME = "username";
    private static final Integer USER_ID = 1;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserDtoConvert userDtoConvert;

    @Test
    void loadUserByUsername_success() {
        when(userRepository.findByLogin(eq(USERNAME))).thenReturn(Optional.of(
                        new User()
                                .setId(USER_ID)
                                .setLogin(USERNAME)
                                .setName("name")
                                .setLastname("lastname")
                                .setPassword("password")
                                .setRole("role"))

        );

        UserDetails actual = userService.loadUserByUsername(USERNAME);

        assertEquals(USERNAME, actual.getUsername());
    }

    @Test
    void loadUserByUsername_whereUserNotFound_thenThrowException() {
        when(userRepository.findByLogin(eq(USERNAME))).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(USERNAME));
    }

    @Test
    void getUserDto() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(
                new User()
                        .setId(USER_ID)
                        .setLogin(USERNAME)
                        .setName("name")
                        .setLastname("lastname")
                        .setPassword("password")
                        .setRole("role")));
        when(productRepository.findByOwnerId(eq(USER_ID))).thenReturn(List.of(
                new Product()
                        .setId(1)
                        .setName("p1")
                        .setOwnerId(1),
                new Product()
                        .setId(2)
                        .setName("p2")
                        .setOwnerId(1)));
        when(userDtoConvert.convert(any(), any())).thenCallRealMethod();

        UserDto expected = new UserDto()
                .setId(USER_ID)
                .setName("name")
                .setLastname("lastname")
                .setProducts(List.of(
                        new UserDto.UserProductDto()
                                .setId(1)
                                .setName("p1"),
                        new UserDto.UserProductDto()
                                .setId(2)
                                .setName("p2")));

        UserDto actual = userService.getUserDto(USER_ID);

        assertEquals(expected, actual);
    }
}

