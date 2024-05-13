package com.example.yazlab3_mongo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    public static final String SEQUENCE_NAME = "user_sequence";
    private Long id;
    private String username;
    private String email;
    private String password;
    private String interests;
    private String fasttext;
    private String scibert;
}
