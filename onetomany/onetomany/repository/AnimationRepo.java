package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Animation;


@Repository
public interface AnimationRepo extends JpaRepository<Animation,Integer> {

    
    
} 