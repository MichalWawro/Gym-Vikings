package com.example.elgrande.security.service;

import java.util.ArrayList;
import java.util.List;

import com.example.elgrande.model.enums.Role;
import com.example.elgrande.model.user.User;
import com.example.elgrande.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User userEntity = userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : userEntity.roles()) {
            roles.add(new SimpleGrantedAuthority(role.name()));
        }

        return new User(userEntity.username(), userEntity.password(), roles);
    }
}
