package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.onetomany.model.Thriller;
import com.example.onetomany.repository.ThrillerRepo;
@Service
public class ThrillerService {
    
    @Autowired
    private ThrillerRepo thrillerRepo;

    public ResponseEntity<?> postMethod(@RequestBody Thriller thriller)
    {
        try{
            thrillerRepo.save(thriller);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Thriller> getMethodName()
    {
        return thrillerRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Thriller> action = thrillerRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Thriller thriller)
    {
        Optional<Thriller> existingAction = thrillerRepo.findById(id);
        if(existingAction.isPresent()) {
            thriller.setId(id);
            thrillerRepo.save(thriller);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Thriller> existingAction = thrillerRepo.findById(id);
       if (existingAction.isPresent()) {
            thrillerRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
