package com.example.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Movie;
import com.example.onetomany.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;;

@CrossOrigin("http://localhost:3000")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<Movie> postMethodName1(@RequestBody Movie movie) {
        if (movieService.postMethod(movie) == true) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/movie")
    public List<Movie> getMethodName() {

        return movieService.getMethod();
    }

    @GetMapping("/movie/{id}")
    public Optional<Movie> getMethod(@PathVariable int id) {
        return movieService.getMethodeId(id);
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> putMethodName(@PathVariable int id, @RequestBody Movie movie) {
        if (movieService.putMethodName(id, movie)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Movie> deleteItem(@PathVariable int id) {
        if (movieService.deleteItem(id) == true) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
