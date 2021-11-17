package com.api.wallet.service.impl;

import com.api.wallet.entity.User;
import com.api.wallet.repository.UserRepository;
import com.api.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public User save(User user) {
        return repo.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmailEquals(email);
    }
}
