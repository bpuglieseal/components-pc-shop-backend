package com.componentsshop.apps.backend.controllers.authentication.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginControllerRequest {
    @Email(message = "{user.email.invalid}")
    private String username;


    @NotBlank(message = "{user.password.required}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
