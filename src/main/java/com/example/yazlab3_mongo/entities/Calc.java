package com.example.yazlab3_mongo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "calc")
public class Calc {
    @Transient
    public static final String SEQUENCE_NAME = "calc_sequence";
    @Id
    //@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private float cosine_similarity;
    @OneToOne(fetch =  FetchType.EAGER)//lazy user objeai gelmesin diye
    @JoinColumn(name = "veri_id",nullable = false)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private User user;
    @OneToOne(fetch =  FetchType.EAGER)//lazy user objeai gelmesin diye
    @JoinColumn(name = "veri_id",nullable = false)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    private com.example.yazlab3_mongo.entities.Data data;
}
