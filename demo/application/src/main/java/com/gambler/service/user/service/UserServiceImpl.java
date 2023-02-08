package com.gambler.service.user.service;

import com.gambler.service.user.converter.UserConverter;
import com.gambler.service.user.model.User;
import gmongo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public Optional<User> findById(Integer id) {
        return userConverter.convert(userRepository.findById(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User is not found");
        }
        return user.get();
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userConverter.convert(userRepository.findByLogin(login));
    }
}
