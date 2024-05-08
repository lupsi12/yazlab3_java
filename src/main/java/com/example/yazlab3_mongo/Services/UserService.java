package com.example.yazlab3_mongo.Services;

import com.example.yazlab3_mongo.Requests.UserCreateRequest;
import com.example.yazlab3_mongo.Responses.UserResponse;
import com.example.yazlab3_mongo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserResponse> getAllUsers(Optional<String> email, Optional<String> password);
    UserResponse getUserById(Long userId);
    User addUser(UserCreateRequest userCreateRequest);
    void deleteUser(Long id);
    void deleteAllUsers();
}
