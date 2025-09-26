package com.neurofleetx.auth.dto;



import com.neurofleetx.auth.model.Role;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
    // Getters and setters
}