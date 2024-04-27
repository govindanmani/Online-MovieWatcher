package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Movie;
import com.example.onetomany.repository.MovieRepo;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public boolean postMethod(Movie movie) {
        try {
            movieRepo.save(movie);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Movie> getMethod() {
        return movieRepo.findAll();
    }

    public Optional<Movie> getMethodeId(int id) {
        return movieRepo.findById(id);
    }

    public boolean putMethodName(int id, Movie movie) {
        if (this.getMethodeId(id) == null)
            return false;
        movieRepo.save(movie);
        return true;
    }

    public boolean deleteItem(int id) {
        if (this.getMethodeId(id) == null)
            return false;
        movieRepo.deleteById(id);
        return true;
    }

}
