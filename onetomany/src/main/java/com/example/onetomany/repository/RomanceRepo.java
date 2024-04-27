package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Romance;
@Repository
public interface RomanceRepo  extends JpaRepository<Romance,Integer>{

    
}