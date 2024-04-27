package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Mistry;
@Repository
public interface MistryRepo extends JpaRepository<Mistry,Integer> {

    
} 