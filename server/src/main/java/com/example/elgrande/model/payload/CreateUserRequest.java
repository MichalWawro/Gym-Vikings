package com.example.elgrande.model.payload;


import com.example.elgrande.model.enums.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>(List.of(Role.USER));
}
