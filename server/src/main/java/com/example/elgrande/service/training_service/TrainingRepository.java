package com.example.elgrande.service.training_service;

import com.example.elgrande.model.enums.Level;
import com.example.elgrande.model.training.Exercise;
import com.example.elgrande.model.training.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Integer> {
}
