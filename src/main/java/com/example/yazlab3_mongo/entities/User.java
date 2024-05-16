package com.example.yazlab3_mongo.entities;

import com.example.yazlab3_mongo.Responses.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    @Id
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)
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

    public User(UserResponse userResponse) {
        this.id = userResponse.getId();
        this.username = userResponse.getUsername();
    }
}
