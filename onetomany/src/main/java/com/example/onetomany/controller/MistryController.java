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

import com.example.onetomany.model.Mistry;
import com.example.onetomany.service.MistryService;

@CrossOrigin("http://localhost:3000")
@RestController
public class MistryController {
    

    @Autowired
    private MistryService mistryService;
    @PostMapping("/Mistry")
    public ResponseEntity<?> postMethodName(@RequestBody Mistry mistry) {
        return mistryService.postMethod(mistry);
    }

    @GetMapping("/Mistry")
    public List<Mistry> getMethodName() {
        return mistryService.getMethodName();
    }

    @GetMapping("/Mistry/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return mistryService.getMethod(id);
    }

    @PutMapping("/Mistry/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Mistry mistry) {
        return mistryService.putMethodName(id, mistry);
    }

    @DeleteMapping("/Mistry/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return mistryService.deleteItem(id);
    }
}
