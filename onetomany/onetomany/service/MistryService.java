package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Mistry;
import com.example.onetomany.repository.MistryRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class MistryService {
    
    @Autowired
    private MistryRepo mistryRepo;
         public ResponseEntity<?> postMethod(@RequestBody Mistry mistry)
    {
        try{
            mistryRepo.save(mistry);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Mistry> getMethodName()
    {
        return mistryRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Mistry> action = mistryRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Mistry mistry)
    {
        Optional<Mistry> existingAction = mistryRepo.findById(id);
        if(existingAction.isPresent()) {
            mistry.setId(id);
            mistryRepo.save(mistry);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Mistry> existingAction = mistryRepo.findById(id);
       if (existingAction.isPresent()) {
            mistryRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}


