package com.nugrohosamiyono.studyjam.application.request.v1;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserCreate {

    @NotNull(message = "name boleh null")
    @NotBlank(message = "name boleh blank")
    private String name;
    
    @NotNull(message = "age boleh null")
    @Max(value = 10L)
    private int age;

}
