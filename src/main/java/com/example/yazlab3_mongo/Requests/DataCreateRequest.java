package com.example.yazlab3_mongo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCreateRequest {
    public static final String SEQUENCE_NAME = "data_sequence";
    private Long id;
    private String name;
    private String title;
    private String abstract_;
    private String fulltext;
    private String keywords;
    private String fasttext;
    private String scibert;
}
