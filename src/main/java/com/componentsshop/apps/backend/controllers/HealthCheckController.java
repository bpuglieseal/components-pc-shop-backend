package com.componentsshop.apps.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public Object healthCheck() {
        HashMap<String, Object> object = new HashMap<>();
        object.put("status", "OK");
        return object;
    }
}
