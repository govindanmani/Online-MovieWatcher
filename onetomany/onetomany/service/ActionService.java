// package com.example.onetomany.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.onetomany.model.Action;
// import com.example.onetomany.repository.ActionRepo;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;
// @Service
// public class ActionService {
    
//     @Autowired
//     private ActionRepo actionRepo;

//     public boolean postMethod(@RequestBody Action action)
//     {
//         try{
//             actionRepo.save(action);
//         }
//         catch(Exception e)
//         {
//             System.out.println(e.getMessage());
//             return false;
//         }
//         return true;
//     }


//     public List<Action> getMethodName()
//     {
//         return actionRepo.findAll();
//     }

//     public Optional<Action> getMethod(int id)
//     {
//         return actionRepo.findById(id);
//     }


//     public boolean putMethodName(int id,Action action)
//     {
//         if(this.getMethod(id)==null)
//         {
//             return false;
//         }
//         actionRepo.save(action);
//         return true;
//     }

//     public boolean deleteItem(int id)
//     {
//        if (this.getMethod(id)==null)
//         return false;
//        actionRepo.deleteById(id);
//        return true;
//     }
// }





package com.example.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onetomany.model.Action;
import com.example.onetomany.repository.ActionRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class ActionService {
    
    @Autowired
    private ActionRepo actionRepo;

    public ResponseEntity<?> postMethod(@RequestBody Action action)
    {
        try{
            actionRepo.save(action);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Action> getMethodName()
    {
        return actionRepo.findAll();
    }

    public ResponseEntity<?> getMethod(int id)
    {
        Optional<Action> action = actionRepo.findById(id);
        if(action.isPresent()) {
            return new ResponseEntity<>(action.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> putMethodName(int id, Action action)
    {
        Optional<Action> existingAction = actionRepo.findById(id);
        if(existingAction.isPresent()) {
            action.setId(id);
            actionRepo.save(action);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteItem(int id)
    {
       Optional<Action> existingAction = actionRepo.findById(id);
       if (existingAction.isPresent()) {
            actionRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
       } else {
            return new ResponseEntity<>("Action not found", HttpStatus.NOT_FOUND);
       }
    }
}

