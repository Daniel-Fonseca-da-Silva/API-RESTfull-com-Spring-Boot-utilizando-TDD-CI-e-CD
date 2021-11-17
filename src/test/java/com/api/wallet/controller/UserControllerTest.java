package com.api.wallet.controller;

import com.api.wallet.entity.User;
import com.api.wallet.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String NAME = 'usuario';
    private static final String EMAIL = 'teste@gmail.com';
    private static final String PASSWORD = '12345';
    private static final String URL = '/user';

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    public void testSave() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload()).
                contentType(MediaType.APPLICATION_JSON).
                accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public User getMockUser() {

        User user = new User();
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);

        return user;
    }

    public String getJsonPayload() {

        UserDTO dto = new UserDTO();
        dto.setName(NAME);
        dto.setEmail(EMAIL);
        dto.setPassword(PASSWORD);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);

    }

}
