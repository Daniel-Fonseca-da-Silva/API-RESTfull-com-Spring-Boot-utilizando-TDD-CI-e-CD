package com.api.wallet.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // Add an empty constructor
public class Response<T> {

    private T data;
    private List<String> errors;

}
