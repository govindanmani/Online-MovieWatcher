package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetomany.model.Action;

public interface ActionRepo extends JpaRepository<Action,Integer> {

    
} 