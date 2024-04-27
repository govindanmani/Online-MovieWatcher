package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Comedy;
import com.example.onetomany.repository.ComedyRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@Service
public class ComedyService {
    
    @Autowired
    private ComedyRepo comedyRepo;

    public ResponseEntity<?> postMethod(@RequestBody Comedy comedy)
    {
        try{
            comedyRepo.save(comedy);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Comedy> getMethodName()
    {
        return comedyRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Comedy> action = comedyRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Comedy comedy)
    {
        Optional<Comedy> existingAction = comedyRepo.findById(id);
        if(existingAction.isPresent()) {
            comedy.setId(id);
            comedyRepo.save(comedy);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Comedy> existingAction = comedyRepo.findById(id);
       if (existingAction.isPresent()) {
            comedyRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
