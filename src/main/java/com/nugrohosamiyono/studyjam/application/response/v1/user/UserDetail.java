package com.nugrohosamiyono.studyjam.application.response.v1.user;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDetail {
    
    private String name;
    private int age;

}
