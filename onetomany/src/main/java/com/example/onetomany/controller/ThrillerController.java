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

import com.example.onetomany.model.Thriller;
import com.example.onetomany.service.ThrillerService;
@CrossOrigin("http://localhost:3000")
@RestController
public class ThrillerController {
    

    @Autowired 
    private ThrillerService thrillerService;
    @PostMapping("/Thriller")
    public ResponseEntity<?> postMethodName(@RequestBody Thriller thriller) {
        return thrillerService.postMethod(thriller);
    }

    @GetMapping("/Thriller")
    public List<Thriller> getMethodName() {
        return thrillerService.getMethodName();
    }

    @GetMapping("/Thriller/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return thrillerService.getMethod(id);
    }

    @PutMapping("/Thriller/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Thriller thriller) {
        return thrillerService.putMethodName(id, thriller);
    }

    @DeleteMapping("/Thriller/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return thrillerService.deleteItem(id);
    }
}
