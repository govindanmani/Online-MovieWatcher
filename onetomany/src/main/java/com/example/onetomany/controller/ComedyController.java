package com.example.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Comedy;
import com.example.onetomany.service.ComedyService;

@CrossOrigin("http://localhost:3000")
@RestController
public class ComedyController {

    @Autowired
    private ComedyService comedyService;
    
    @PostMapping("/Comedy")
    public ResponseEntity<?> postMethodName(@RequestBody Comedy comedy) {
        return comedyService.postMethod(comedy);
    }

    @GetMapping("/Comedy")
    public List<Comedy> getMethodName() {
        return comedyService.getMethodName();
    }

    @GetMapping("/Comedy/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return comedyService.getMethod(id);
    }

    @PutMapping("/Comedy/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Comedy comedy) {
        return comedyService.putMethodName(id, comedy);
    }

    @DeleteMapping("/Comedy/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return comedyService.deleteItem(id);
    }
}
