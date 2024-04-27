package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Adventure;
import com.example.onetomany.repository.AdventureRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@Service
public class AdventureService {
    
    @Autowired
        private AdventureRepo adventureRepo;
         public ResponseEntity<?> postMethod(@RequestBody Adventure adventure)
    {
        try{
            adventureRepo.save(adventure);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Adventure> getMethodName()
    {
        return adventureRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Adventure> action = adventureRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Adventure adventure)
    {
        Optional<Adventure> existingAction = adventureRepo.findById(id);
        if(existingAction.isPresent()) {
            adventure.setId(id);
            adventureRepo.save(adventure);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Adventure> existingAction = adventureRepo.findById(id);
       if (existingAction.isPresent()) {
            adventureRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}