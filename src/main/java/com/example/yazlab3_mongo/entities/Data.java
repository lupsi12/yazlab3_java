package com.example.yazlab3_mongo.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "data")
public class Data {
    @Transient
    public static final String SEQUENCE_NAME = "data_sequence";
    @Id
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String abstract_;
    private String fulltext;
    private String keywords;


}
