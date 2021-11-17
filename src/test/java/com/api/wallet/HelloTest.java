package com.api.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Profile("test")
public class HelloTest {

    @Test
    public void testHello() {
        assertEquals(1, 1);
    }

}
