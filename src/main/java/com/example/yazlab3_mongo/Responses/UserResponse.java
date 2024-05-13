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
    private String interests;
    private String fasttext;
    private String scibert;
    private float recall;
    private float precision;
    private String secim;
    public UserResponse(User userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.interests = userEntity.getInterests();
        this.fasttext = userEntity.getFasttext();
        this.scibert = userEntity.getScibert();
        this.recall = userEntity.getRecall();
        this.precision = userEntity.getPrecision();
        this.secim = userEntity.getSecim();
    }
}
