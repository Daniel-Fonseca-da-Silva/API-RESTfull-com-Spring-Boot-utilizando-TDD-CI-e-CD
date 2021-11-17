package com.api.wallet.repository;

import com.api.wallet.entity.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "teste@gmail.com";

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

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail() {
        Optional<User> response = repo.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
