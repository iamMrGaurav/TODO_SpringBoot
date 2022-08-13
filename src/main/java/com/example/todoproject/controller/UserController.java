package com.example.todoproject.controller;

import com.example.todoproject.entities.User;
import com.example.todoproject.exception.ResourceNotFoundException;
import com.example.todoproject.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUser() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("URL NOT FOUND !!");
        }
    }


    @PostMapping("/create")

    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody User user, @PathVariable int id) {
        try {
            return new ResponseEntity<>(userService.updateUserById(id, user), HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("URL NOT FOUND !!");
        }
    }


}
