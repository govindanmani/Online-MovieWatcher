package com.example.onetomany.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Login;
import com.example.onetomany.repository.LoginRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class LoginService {

    @Autowired
    private LoginRepo loginRepo;

    public ResponseEntity<?> register(@RequestBody Login login) {
        try {
            loginRepo.save(login);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Login> login(String email, String password) {
        Optional<Login> isExistingUser = loginRepo.findById(email);
        if (isExistingUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Login user = isExistingUser.get();
        if (!password.equals(user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> getMethod(String email) {
        Optional<Login> action = loginRepo.findById(email);
        if (action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(String email, Login login) {
        Optional<Login> existingAction = loginRepo.findById(email);
        if (existingAction.isPresent()) {
            // login.setId(email);
            loginRepo.save(login);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(String email) {
        Optional<Login> existingAction = loginRepo.findById(email);
        if (existingAction.isPresent()) {
            loginRepo.deleteById(email);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

}

// @Autowired
// private LoginRepo loginRepo;

// public boolean postMethod(@RequestBody Login login)
// {
// try{
// loginRepo.save(login);
// }
// catch(Exception e)
// {
// System.out.println(e.getMessage());
// return false;
// }
// return true;
// }

// public List<Login> getMethodName()
// {
// return loginRepo.findAll();
// }

// public Optional<Login> getMethod(String email)
// {
// return loginRepo.findById(email);
// }

// public boolean postMethod(String email,Login login)
// {
// if(this.getMethod(email)==null)
// {
// return false;
// }
// loginRepo.save(login);
// return true;
// }

// public boolean deleteItem(String email)
// {
// if (this.getMethod(email)==null)
// return false;
// loginRepo.deleteById(email);
// return true;
// }