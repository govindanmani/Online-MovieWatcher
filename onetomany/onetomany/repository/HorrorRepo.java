package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Horror;
@Repository
public interface HorrorRepo extends JpaRepository<Horror,Integer> {
    
}