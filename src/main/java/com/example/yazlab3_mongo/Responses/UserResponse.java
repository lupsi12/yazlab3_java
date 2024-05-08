package com.example.yazlab3_mongo.Responses;

import com.example.yazlab3_mongo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String password;

    public UserResponse(User userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }
}
