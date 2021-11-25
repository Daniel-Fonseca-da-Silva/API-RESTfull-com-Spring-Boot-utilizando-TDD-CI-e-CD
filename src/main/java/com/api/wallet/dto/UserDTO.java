package com.api.wallet.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class UserDTO {

    private Long id;

    @Email(message = "email inválido")
    private String email;

    @Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;

    @Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
    private String password;

}
