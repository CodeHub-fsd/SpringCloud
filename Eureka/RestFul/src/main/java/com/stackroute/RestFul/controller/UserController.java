package com.stackroute.RestFul.controller;

import com.stackroute.RestFul.model.User;
import com.stackroute.RestFul.service.UserService;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    //Constructor based autowiring
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try {
//            userService.saveUser(user);
            String fullNameConcat = user.getFirstName() + user.getLastName();
            user.setFullName(fullNameConcat);
            userService.saveUser(user);
            responseEntity = new ResponseEntity<>("User stored successfully", HttpStatus.OK);
        } catch(Exception exc) {
            responseEntity = new ResponseEntity<>("User not saved due to internal error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        ResponseEntity responseEntity;
        try {
            List<User> allUsers = userService.getAllUsers();
            responseEntity = new ResponseEntity<>(allUsers, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByID(@PathVariable Integer id){
        ResponseEntity responseEntity;
        try {
            Optional<User> userById = userService.getById(id);
            responseEntity = new ResponseEntity<>( , HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PatchMapping("/update/{id}/{newTele}")
    public ResponseEntity<?> updateById(@PathVariable Integer id, @PathVariable Integer newTele){
        ResponseEntity responseEntity;
        try{
            String message = userService.updateById(id, newTele);
            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/updatePut")
    public ResponseEntity<?> updateById(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            userService.updateByIdPut(user);
            responseEntity = new ResponseEntity<>("updated successfully", HttpStatus.OK);
        } catch (Exception exc) {
            responseEntity = new ResponseEntity<>("Error", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
