package com.componentsshop.apps.backend.controllers.authentication.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginControllerRequest {
    @Email
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
