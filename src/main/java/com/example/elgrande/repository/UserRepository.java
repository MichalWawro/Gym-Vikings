package com.example.elgrande.repository;

import com.example.elgrande.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom query methods if needed
}