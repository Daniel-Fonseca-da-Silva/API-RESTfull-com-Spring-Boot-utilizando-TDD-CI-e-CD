package com.api.wallet.controller;

import com.api.wallet.entity.User;
import com.api.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();
        User user = service.save(this.convertDtoToEntity(dto));
        response.setData(this.convertEntityToDto(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Convert Entity to UserDTO
    private User convertDtoToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName);
        user.setEmail(dto.getEmail);
        user.setPassword(dto.getPassword);
        return user;
    }

    // Convert DTO to Entity
    private UserDTO convertEntityToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName);
        dto.setEmail(user.getEmail);
        dto.setPassword(user.getPassword);
        return dto;
    }

}
