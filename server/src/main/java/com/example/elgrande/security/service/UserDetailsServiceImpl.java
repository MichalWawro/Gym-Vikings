package com.example.elgrande.security.service;

import java.util.ArrayList;
import java.util.List;

import com.example.elgrande.model.role.Role;
import com.example.elgrande.model.user.UserEntity;
import com.example.elgrande.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
