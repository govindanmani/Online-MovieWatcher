package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.onetomany.model.Romance;
import com.example.onetomany.repository.RomanceRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class RomanceService {
    
    @Autowired
    private RomanceRepo romanceRepo;
         public ResponseEntity<?> postMethod(@RequestBody Romance romance)
    {
        try{
            romanceRepo.save(romance);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Romance> getMethodName()
    {
        return romanceRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Romance> action = romanceRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Romance romance)
    {
        Optional<Romance> existingAction = romanceRepo.findById(id);
        if(existingAction.isPresent()) {
            romance.setId(id);
            romanceRepo.save(romance);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Romance> existingAction = romanceRepo.findById(id);
       if (existingAction.isPresent()) {
            romanceRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}

