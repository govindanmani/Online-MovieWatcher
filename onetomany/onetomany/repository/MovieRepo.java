package com.example.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.onetomany.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

    
} 