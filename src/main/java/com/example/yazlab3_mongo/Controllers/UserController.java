package com.example.yazlab3_mongo.Controllers;

import com.example.yazlab3_mongo.Requests.UserCreateRequest;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.Services.UserService;
import com.example.yazlab3_mongo.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<UserResponse> getAllUsers(@RequestParam Optional<String> email, @RequestParam Optional<String> password){
        return userService.getAllUsers(email,password);
    }
    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PostMapping
    public User addUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.addUser(userCreateRequest);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
    @DeleteMapping
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }
}
