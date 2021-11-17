package com.api.wallet.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
public class UserRepositoryTest {

    @Autowired
    userRepository repository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName();
        user.setEmail();
        user.setPassword();

        User response = repository.save();

        Assertions.assertNotNull(response);
    }
}
