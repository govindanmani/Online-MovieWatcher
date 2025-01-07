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
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Fantsy;
import com.example.onetomany.service.FantsyService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin("http://localhost:3000")
@RestController
public class FantsyController {
    
    @Autowired
    private FantsyService fantsyService;
     @PostMapping("/Fantsy")
    public ResponseEntity<?> postMethodName(@RequestBody Fantsy fantsy) {
        return fantsyService.postMethod(fantsy);
    }

    @GetMapping("/Fantsy")
    public List<Fantsy> getMethodName() {
        return fantsyService.getMethodName();
    }

    @GetMapping("/Fantsy/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return fantsyService.getMethod(id);
    }

    @PutMapping("/Fantsy/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Fantsy fantsy) {
        return fantsyService.putMethodName(id, fantsy);
    }

    @DeleteMapping("/Fantsy/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return fantsyService.deleteItem(id);
    }
}
