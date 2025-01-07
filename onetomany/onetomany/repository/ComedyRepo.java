package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Comedy;
@Repository
public interface ComedyRepo  extends JpaRepository<Comedy,Integer>{

    
} 