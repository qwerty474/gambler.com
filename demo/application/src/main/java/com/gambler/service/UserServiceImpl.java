package com.gambler.service;

import com.gambler.entities.CustomUserDetails;
import gmongo.model.UserMng;
import gmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserMng> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomUserDetails> user = findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User is not found");
        }
        return user.get();
    }

    @Override
    public Optional<CustomUserDetails> findByLogin(String login) {
        Optional<UserMng> user = userRepository.findByLogin(login);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new CustomUserDetails(user.get()));
    }
}
