package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Fantsy;
@Repository
public interface FantsyRepo extends JpaRepository<Fantsy,Integer>{

    
} 