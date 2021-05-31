package com.gitmuts.testmwallet.controller;

import com.gitmuts.testmwallet.entity.User;
import com.gitmuts.testmwallet.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        List<User> usersList = userRepository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        log.info("Received create request {}", user);
        userRepository.save(user);
        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }

    //PUT
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>("User Updated", HttpStatus.OK);
    }

    //delete
    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        userRepository.delete(user);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<?> getUsersByLastName(@PathVariable("lastName") String lastName){
        return new ResponseEntity(userRepository.findByLastName(lastName), HttpStatus.OK);
    }
}
