package com.gambler.service.user.service;

import com.gambler.controller.user.convert.UserDtoConvert;
import com.gambler.controller.user.model.UserDto;
import com.gambler.error.exception.BackendException;
import com.gambler.error.exception.CabinetError;
import com.gambler.service.product.model.Product;
import com.gambler.service.product.repository.ProductRepository;
import com.gambler.service.user.model.User;
import com.gambler.service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final UserDtoConvert userDtoConvert;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User is not found");
        }
        return user.get();
    }

    public UserDto getUserDto(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new BackendException(CabinetError.NOT_FOUND);
        }

        User user = optionalUser.get();

        List<Product> products = productRepository.findByOwnerId(user.getId());

        return userDtoConvert.convert(user, products);
    }

}
