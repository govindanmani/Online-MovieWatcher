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
import com.example.onetomany.model.Romance;
import com.example.onetomany.service.RomanceService;

@CrossOrigin("http://localhost:3000")
@RestController
public class RomanceController {
    
    @Autowired
    private RomanceService romanceService;
    @PostMapping("/Romance")
    public ResponseEntity<?> postMethodName(@RequestBody Romance romance) {
        return romanceService.postMethod(romance);
    }

    @GetMapping("/Romance")
    public List<Romance> getMethodName() {
        return romanceService.getMethodName();
    }

    @GetMapping("/Romance/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return romanceService.getMethod(id);
    }

    @PutMapping("/Romance/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Romance romance) {
        return romanceService.putMethodName(id, romance);
    }

    @DeleteMapping("/Romance/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return romanceService.deleteItem(id);
    }
}
