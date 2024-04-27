package com.example.onetomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Login;
import com.example.onetomany.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:3000")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<?> postMethodName(@RequestBody Login login) {
        return loginService.register(login);
    }

    @PostMapping("/login")
    public ResponseEntity<?> getMethodName(@RequestBody Login login) {
        return loginService.login(login.getEmail(), login.getPassword());
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<?> getMethod(@PathVariable String email) {
        return loginService.getMethod(email);
    }

    @PutMapping("/login/{email}")
    public ResponseEntity<?> putMethodName(@PathVariable String email, @RequestBody Login login) {
        return loginService.putMethodName(email, login);
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String email) {
        return loginService.deleteItem(email);
    }

}

// @PostMapping("/login")
// public ResponseEntity<Login> postMethodName(@RequestBody Login login) {
// if(loginService.postMethod(login))
// {
// return new ResponseEntity<>(HttpStatus.CREATED);
// }
// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// }

// @GetMapping("/login")
// public List<Login> getMethodName() {
// return loginService.getMethodName();
// }

// @GetMapping("/login/{email}")
// public Optional<Login> getMethod(@PathVariable String email) {
// return loginService.getMethod(email);
// }

// @PutMapping("login/{email}")
// public ResponseEntity<Login> putMethodName(@PathVariable String email,
// @RequestBody Login login) {
// if(loginService.postMethod(email,login))
// {
// return new ResponseEntity<>(HttpStatus.CREATED);
// }
// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// }

// @DeleteMapping("/login/{email}")
// public ResponseEntity<Movie> deleteItem(@PathVariable String email)
// {
// if(loginService.deleteItem(email)==true)
// {
// return new ResponseEntity<>(HttpStatus.CREATED);
// }
// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// }
