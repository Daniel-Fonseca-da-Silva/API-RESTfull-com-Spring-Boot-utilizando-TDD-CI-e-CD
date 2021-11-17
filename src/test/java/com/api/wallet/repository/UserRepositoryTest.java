package com.api.wallet.repository;

import com.api.wallet.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("Teste");
        user.setEmail("teste@gmail.com");
        user.setPassword("12345");

        User response = repository.save(user);

        Assertions.assertNotNull(response);
    }
}
