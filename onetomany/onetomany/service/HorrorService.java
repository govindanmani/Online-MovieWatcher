package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.onetomany.model.Horror;
import com.example.onetomany.repository.HorrorRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class HorrorService {

    @Autowired
    private HorrorRepo horrorRepo;

    public ResponseEntity<?> postMethod(@RequestBody Horror horror) {
        try {
            horrorRepo.save(horror);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Horror> getMethodName() {
        return horrorRepo.findAll();
    }

    public void FetchAll() {
        List<Horror> h = horrorRepo.findAll();
        for (Horror m : h) {
            m.setPrice(23);
            horrorRepo.save(m);
        }
    }

    public ResponseEntity<?> getMethod(int id) {
        Optional<Horror> action = horrorRepo.findById(id);
        if (action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Horror horror) {
        Optional<Horror> existingAction = horrorRepo.findById(id);
        if (existingAction.isPresent()) {
            horror.setId(id);
            horrorRepo.save(horror);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id) {
        Optional<Horror> existingAction = horrorRepo.findById(id);
        if (existingAction.isPresent()) {
            horrorRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }
}
