package com.example.elgrande.model.payload;

import com.example.elgrande.model.user.UserEntity;
import org.springframework.security.core.userdetails.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String jwt;

    private String userName;
    private UserEntity user;

    private List<String> roles;
}
