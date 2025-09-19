package com.componentsshop.apps.backend.controllers.authentication.login;

import contexts.shop.users.application.login.UserLogin;
import contexts.shop.users.application.login.UserLoginRequest;
import contexts.shop.users.application.login.UserLoginResponse;
import contexts.shop.users.domain.UserNotExists;
import contexts.shop.users.domain.UserWrongCredentials;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    private final UserLogin login;

    LoginController(final UserLogin login) {
        this.login = login;
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody @Valid LoginControllerRequest body) {
        HashMap<String, Object> response = new HashMap<>();

        try {
            String username = body.getUsername();
            String password = body.getPassword();
            UserLoginRequest request = new UserLoginRequest(username, password);
            UserLoginResponse token = this.login.run(request);

            response.put("token", token.getToken());
            response.put("status", HttpStatus.OK.value());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UserNotExists | UserWrongCredentials e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
