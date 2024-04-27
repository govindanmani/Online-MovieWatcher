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

import com.example.onetomany.model.Animation;
import com.example.onetomany.service.AnimationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@CrossOrigin("http://localhost:3000")
@RestController
public class AnimationController {
    
    @Autowired
    private AnimationService animationService;

    @PostMapping("/Animation")
    public ResponseEntity<?> postMethodName(@RequestBody Animation animation) {
        return animationService.postMethod(animation);
    }

    @GetMapping("/Animation")
    public List<Animation> getMethodName() {
        return animationService.getMethodName();
    }

    @GetMapping("/Animation/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return animationService.getMethod(id);
    }

    @PutMapping("/Animation/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Animation animation) {
        return animationService.putMethodName(id, animation);
    }

    @DeleteMapping("/Animation/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return animationService.deleteItem(id);
    }
}
