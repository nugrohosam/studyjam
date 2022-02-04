package com.nugrohosamiyono.studyjam.application.request.v1;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserUpdate {
    
    @NotNull
    @Max(value = 10L)
    private int age;
    
}
