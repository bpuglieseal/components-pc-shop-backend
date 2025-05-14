package com.componentsshop.apps.backend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ComponentsShopBackendApplicationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnOKCode () {
        ResponseEntity<Object> response = restTemplate.getForEntity("/health", Object.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}