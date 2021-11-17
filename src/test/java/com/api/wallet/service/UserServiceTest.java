package com.api.wallet.service;

import com.api.wallet.entity.User;
import com.api.wallet.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@Profile("test")
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserRepository repo;

    @Autowired
    UserService service;

    @Before
    public void setUp() {
        BDDMockito.given(repo.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @Test
    public void testFindByEmail() {
        Optional<User> user = service.findByEmail("teste@gmail.com");

        Assertions.assertTrue(user.isPresent());
    }

}
