// package com.example.onetomany.controller;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.onetomany.model.Action;
// import com.example.onetomany.model.Movie;
// import com.example.onetomany.service.ActionService;


// @CrossOrigin("http://localhost:3000")
// @RestController
// public class ActionController {
    
//     @Autowired
//     private ActionService actionService;

//      @PostMapping("/action")
//     public ResponseEntity<Action> postMethodName(@RequestBody Action action) {
//         if(actionService.postMethod(action))
//         {
//             return new ResponseEntity<>(HttpStatus.CREATED);
//         }
//         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//     }

//     @GetMapping("/action")
//     public List<Action> getMethodName() {
//         return actionService.getMethodName();
//     }


//     @GetMapping("/action/{id}")
//     public Optional<Action> getMethod(@PathVariable int id) {
//         return actionService.getMethod(id);
//     }


//     @PutMapping("/action/{id}")
//     public ResponseEntity<Action> putMethodName(@PathVariable int id, @RequestBody Action action) {
//         if(actionService.putMethodName(id,action))
//         {
//             return new ResponseEntity<>(HttpStatus.CREATED);
//         }
//         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//     }

    
//      @DeleteMapping("/action/{id}")
//     public ResponseEntity<Movie> deleteItem(@PathVariable int id)
//     {
//         if(actionService.deleteItem(id)==true)
//         {
//             return new ResponseEntity<>(HttpStatus.CREATED);
//         }
//         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//     }



// }




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

import com.example.onetomany.model.Action;
import com.example.onetomany.service.ActionService;

@CrossOrigin("http://localhost:3000")
@RestController
public class ActionController {
    
    @Autowired
    private ActionService actionService;

    @PostMapping("/action")
    public ResponseEntity<?> postMethodName(@RequestBody Action action) {
        return actionService.postMethod(action);
    }

    @GetMapping("/action")
    public List<Action> getMethodName() {
        return actionService.getMethodName();
    }

    @GetMapping("/action/{id}")
    public ResponseEntity<?> getMethod(@PathVariable int id) {
        return actionService.getMethod(id);
    }

    @PutMapping("/action/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable int id, @RequestBody Action action) {
        return actionService.putMethodName(id, action);
    }

    @DeleteMapping("/action/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        return actionService.deleteItem(id);
    }
}
