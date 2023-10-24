package com.example.elgrande.service.training_service;

import com.example.elgrande.model.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Integer> {
}
