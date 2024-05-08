package com.example.yazlab3_mongo.entities;

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
}
