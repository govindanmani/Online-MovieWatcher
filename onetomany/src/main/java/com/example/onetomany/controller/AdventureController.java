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

import com.example.onetomany.model.Adventure;
import com.example.onetomany.service.AdventureService;

@CrossOrigin("http://localhost:3000")
@RestController
public class AdventureController {
    
    @Autowired

    private AdventureService adventureService;
    @PostMapping("/Adventure")
    public ResponseEntity<?> postMethodName(@RequestBody Adventure adventure) {
        return adventureService.postMethod(adventure);
    }

    @GetMapping("/Adventure")
    public List<Adventure> getMethodName() {
        return adventureService.getMethodName();
    }

    @GetMapping("/Adventure/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return adventureService.getMethod(id);
    }

    @PutMapping("/Adventure/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Adventure adventure){
        return adventureService.putMethodName(id, adventure);
    }

    @DeleteMapping("/Adventure/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return adventureService.deleteItem(id);
    }
}


