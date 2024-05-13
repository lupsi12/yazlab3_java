package com.example.yazlab3_mongo.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcCreateRequest {
    public static final String SEQUENCE_NAME = "calc_sequence";
    private Long id;
    private float cosine_similarity_fasttext;
    private float cosine_similarity_scibert;
    private Long user_id;
    private Long data_id;
    private boolean like;
}