package com.componentsshop.apps.backend.controllers;

import contexts.shared.auth.infrastructure.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckController {
    private TokenProvider provider;

    HealthCheckController(TokenProvider provider) {
        this.provider = provider;
    }

    @GetMapping("/health")
    public Object healthCheck() {
        HashMap<String, Object> object = new HashMap<>();
        object.put("token", this.provider.encodeJWT("token"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<Object>(object, headers,HttpStatus.CREATED);
    }
}
