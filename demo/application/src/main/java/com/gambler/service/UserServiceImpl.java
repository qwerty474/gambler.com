package com.gambler.service;

import gmongo.model.UserMng;
import gmongo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
}
