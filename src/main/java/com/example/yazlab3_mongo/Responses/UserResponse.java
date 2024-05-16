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
    private float recall_fasttext;
    private float precision_fasttext;
    private String secim_fasttext;
    private float recall_scibert;
    private float precision_scibert;
    private String secim_scibert;
    public UserResponse(User userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.interests = userEntity.getInterests();
        this.fasttext = userEntity.getFasttext();
        this.scibert = userEntity.getScibert();
        this.recall_fasttext = userEntity.getRecall_fasttext();
        this.precision_fasttext = userEntity.getPrecision_fasttext();
        this.secim_fasttext = userEntity.getSecim_fasttext();
        this.recall_scibert = userEntity.getRecall_scibert();
        this.precision_scibert = userEntity.getPrecision_scibert();
        this.secim_scibert = userEntity.getSecim_scibert();
    }
}
