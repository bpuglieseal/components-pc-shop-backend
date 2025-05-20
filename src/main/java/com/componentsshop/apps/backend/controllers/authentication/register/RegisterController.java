package com.componentsshop.apps.backend.controllers.authentication.register;

import contexts.shop.users.application.register.UserRegister;
import contexts.shop.users.application.register.UserRegisterRequest;
import contexts.shop.users.application.register.UserRegisterResponse;
import contexts.shop.users.domain.UserAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RegisterController {
    private final UserRegister register;
    private final BCryptPasswordEncoder encoder;

    RegisterController(UserRegister register, BCryptPasswordEncoder encoder) {
        this.register = register;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterControllerRequest body) {
        HashMap<String, Object> response = new HashMap<>();

        try {
            String password = body.getPassword();
            String hashedPassword = this.encoder.encode(password);
            UserRegisterRequest registerRequest = new UserRegisterRequest(body.getUsername(), hashedPassword, body.getEmail(), body.getDirection(), body.getDateOfBirth());
            UserRegisterResponse token = this.register.run(registerRequest);

            response.put("token", token.getToken());
            response.put("status", HttpStatus.CREATED.value());

            return new ResponseEntity<>(response.toString(), HttpStatus.CREATED);
        } catch (UserAlreadyExists e) {
            response.put("status", HttpStatus.CONFLICT.value());
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response.toString(), HttpStatus.CONFLICT);
        }
    }
}
