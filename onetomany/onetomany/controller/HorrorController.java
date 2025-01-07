package com.example.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomany.model.Horror;
import com.example.onetomany.service.HorrorService;

@CrossOrigin("http://localhost:3000")
@RestController
public class HorrorController {

    @Autowired
    private HorrorService horrorService;

    @PostMapping("/horror")
    public ResponseEntity<?> postMethodName(@RequestBody Horror horror) {
        return horrorService.postMethod(horror);
    }

    @GetMapping("/horror")
    public List<Horror> getMethodName() {
        // horrorService.FetchAll();
        return horrorService.getMethodName();
    }

    @GetMapping("/horror/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return horrorService.getMethod(id);
    }

    @PutMapping("/horror/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Horror horror) {
        return horrorService.putMethodName(id, horror);
    }

    @DeleteMapping("/horror/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return horrorService.deleteItem(id);
    }
}
