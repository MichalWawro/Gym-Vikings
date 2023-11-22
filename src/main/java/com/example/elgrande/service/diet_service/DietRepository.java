package com.example.elgrande.service.diet_service;

import com.example.elgrande.model.diet.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, Integer> {
}
