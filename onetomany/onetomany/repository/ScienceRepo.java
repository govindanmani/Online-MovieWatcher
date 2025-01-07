package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Science;
@Repository
public interface ScienceRepo  extends JpaRepository<Science,Integer>{

    
} 