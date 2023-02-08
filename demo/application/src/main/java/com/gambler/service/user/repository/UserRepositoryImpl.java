package com.gambler.service.user.repository;

import com.gambler.service.user.converter.UserConverter;
import com.gambler.service.user.model.User;
import gmongo.user.repository.UserMngRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserMngRepository userMngRepository;
    private final UserConverter userConverter;

    @Override
    public Optional<User> findById(Integer id) {
        return userConverter.convert(userMngRepository.findById(id));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userConverter.convert(userMngRepository.findByLogin(login));
    }
}
