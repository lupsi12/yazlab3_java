package com.example.yazlab3_mongo.Requests;

import com.example.yazlab3_mongo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalcCreateRequest {
    public static final String SEQUENCE_NAME = "calc_sequence";
    private Long id;
    private float cosine_similarity;
    private Long user_id;
    private Long data_id;
}