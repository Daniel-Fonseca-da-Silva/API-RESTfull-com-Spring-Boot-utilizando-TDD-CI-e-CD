package com.api.wallet.service;

import com.api.wallet.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);
    Optional<User> findByEmail(String email);

}
