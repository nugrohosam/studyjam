package com.nugrohosamiyono.studyjam.utility;

import com.nugrohosamiyono.studyjam.application.response.ResponseGlobal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    
    public static ResponseEntity<ResponseGlobal> buildV1(Object data) {
        var res = new ResponseGlobal();
        res.setCode(0);
        res.setStatus("OK");
        res.setData(data);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.OK);
    }
    
    public static ResponseEntity<ResponseGlobal> buildErrorV1() {
        var res = new ResponseGlobal();
        res.setCode(-1);
        res.setStatus("SERVER ERROR");
        res.setMessage("INTERNAL SERVER ERROR");

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity<ResponseGlobal> buildBadRequestV1(Object data) {
        var res = new ResponseGlobal();
        res.setCode(-2);
        res.setStatus("BAD REQUEST");
        res.setErorrs(data);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ResponseGlobal> buildErrorBusinessV1(String message) {
        var res = new ResponseGlobal();
        res.setCode(-3);
        res.setStatus("BUSINESS ERROR");
        res.setMessage(message);

        return new ResponseEntity<ResponseGlobal>(res, HttpStatus.BAD_REQUEST);
    }
}
