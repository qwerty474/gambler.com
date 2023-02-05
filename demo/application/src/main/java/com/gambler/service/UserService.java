package com.gambler.service;


import gmongo.model.UserMng;

import java.util.Optional;

public interface UserService {
    Optional<UserMng> findById(Integer id);
}
