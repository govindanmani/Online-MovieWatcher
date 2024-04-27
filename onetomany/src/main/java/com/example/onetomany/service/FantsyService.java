package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.onetomany.model.Fantsy;
import com.example.onetomany.repository.FantsyRepo;

@Service
public class FantsyService {
    

    @Autowired
     private FantsyRepo fantsyRepo;

         public ResponseEntity<?> postMethod(@RequestBody Fantsy fantsy)
    {
        try{
            fantsyRepo.save(fantsy);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Fantsy> getMethodName()
    {
        return fantsyRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Fantsy> action = fantsyRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Fantsy fantsy)
    {
        Optional<Fantsy> existingAction = fantsyRepo.findById(id);
        if(existingAction.isPresent()) {
            fantsy.setId(id);
            fantsyRepo.save(fantsy);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Fantsy> existingAction = fantsyRepo.findById(id);
       if (existingAction.isPresent()) {
            fantsyRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}
