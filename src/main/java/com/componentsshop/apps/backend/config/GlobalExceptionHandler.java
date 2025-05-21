package com.componentsshop.apps.backend.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> response = new HashMap<String, String>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String field = error.getField();
            String message = error.getDefaultMessage();

            response.put(field, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
