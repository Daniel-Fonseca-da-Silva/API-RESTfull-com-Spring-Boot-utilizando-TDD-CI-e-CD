package com.api.wallet.repository;

import com.api.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Optional;

@SpringBootTest
@Profile("test")
public class UserRepositoryTest {

    private static final String EMAIL = "usuario@gmail.com";

    @Autowired
    UserRepository repo;

    @Before
    public void setUp() {
        User user = new User();
        user.setName("usuario");
        user.setEmail(EMAIL);
        user.setPassword("user12345");

        repo.save(user);
    }

    @After
    public void tearDown() {
        repo.deleteAll();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("Teste");
        user.setEmail("teste@gmail.com");
        user.setPassword("12345");

        User response = repo.save(user);

        Assertions.assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {
        Optional<User> response = repo.findByEmail();

        Assertions.assertTrue(response.isPresent());
        Assertions.assertEquals(response.get().getEmail(), EMAIL);
    }
}
