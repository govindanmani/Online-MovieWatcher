package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.model.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login,String> {
    
}