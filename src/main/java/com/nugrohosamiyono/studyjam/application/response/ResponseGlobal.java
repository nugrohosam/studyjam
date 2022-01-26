package com.nugrohosamiyono.studyjam.application.response;

import lombok.Data;

@Data
public class ResponseGlobal {
    
    private int code;
    private String status;
    private Object data;
    
}
