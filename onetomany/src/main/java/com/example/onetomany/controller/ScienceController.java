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

import com.example.onetomany.model.Science;
import com.example.onetomany.service.ScienceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin("http://localhost:3000")
@RestController
public class ScienceController {
    
    @Autowired
    private ScienceService scienceService;
    @PostMapping("/Scientific")
    public ResponseEntity<?> postMethodName(@RequestBody Science science) {
        return scienceService.postMethod(science);
    }

    @GetMapping("/Scientific")
    public List<Science> getMethodName() {
        return scienceService.getMethodName();
    }

    @GetMapping("/Scientific/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return scienceService.getMethod(id);
    }

    @PutMapping("/Scientific/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Science science) {
        return scienceService.putMethodName(id, science);
    }

    @DeleteMapping("/Scientific/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return scienceService.deleteItem(id);
    }

}
