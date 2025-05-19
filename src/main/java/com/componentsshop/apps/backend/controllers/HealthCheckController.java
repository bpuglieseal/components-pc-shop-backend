package com.componentsshop.apps.backend.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public Object healthCheck() {
        HashMap<String, Object> object = new HashMap<>();
        object.put("status", "OK");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<Object>(object, headers, HttpStatus.CREATED);
    }
}
