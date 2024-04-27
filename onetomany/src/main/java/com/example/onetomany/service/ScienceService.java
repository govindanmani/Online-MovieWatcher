package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.onetomany.model.Science;
import com.example.onetomany.repository.ScienceRepo;

@Service
public class ScienceService {
    

    @Autowired
    private ScienceRepo scienceRepo;

    public ResponseEntity<?> postMethod(@RequestBody Science science)
    {
        try{
            scienceRepo.save(science);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Science> getMethodName()
    {
        return scienceRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Science> action = scienceRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Science science)
    {
        Optional<Science> existingAction = scienceRepo.findById(id);
        if(existingAction.isPresent()) {
            science.setId(id);
            scienceRepo.save(science);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Science> existingAction = scienceRepo.findById(id);
       if (existingAction.isPresent()) {
            scienceRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
