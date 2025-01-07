package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Animation;
import com.example.onetomany.repository.AnimationRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@Service
public class AnimationService {
    
    @Autowired
    private AnimationRepo animationRepo;
    public ResponseEntity<?> postMethod(@RequestBody Animation animation)
    {
        try{
            animationRepo.save(animation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Animation> getMethodName()
    {
        return animationRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Animation> action = animationRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Animation animation)
    {
        Optional<Animation> existingAction = animationRepo.findById(id);
        if(existingAction.isPresent()) {
            animation.setId(id);
            animationRepo.save(animation);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Animation> existingAction = animationRepo.findById(id);
       if (existingAction.isPresent()) {
            animationRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
