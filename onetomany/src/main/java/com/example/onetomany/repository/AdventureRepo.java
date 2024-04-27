package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Adventure;
@Repository
public interface AdventureRepo  extends JpaRepository<Adventure,Integer>{

    
} 