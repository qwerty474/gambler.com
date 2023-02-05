package com.example.demo.service;

import com.example.demo.model.UserMng;
import com.example.demo.repository.UserRepository;
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
