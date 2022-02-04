package com.nugrohosamiyono.studyjam.application.request.v1;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserCreate {

    @NotNull(message = "name tdk boleh null")
    @NotBlank(message = "name tdk boleh blank")
    private String name;
    
    @Max(value = 10L)
    @NotNull(message = "age tdk boleh null")
    private Long age;

}
