package com.nugrohosamiyono.studyjam.exceptions;

import java.util.HashMap;
import java.util.Map;

import com.nugrohosamiyono.studyjam.application.response.ResponseGlobal;
import com.nugrohosamiyono.studyjam.utility.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import io.sentry.Sentry;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<ResponseGlobal> handleConflict(
            RuntimeException ex, WebRequest request) {
        Sentry.captureException(ex);
        return Response.buildErrorV1();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseGlobal> handleValidation(
            MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return Response.buildBadRequestV1(errors);
    }

}
