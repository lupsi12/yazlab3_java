package com.example.yazlab3_mongo.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatabaseSequence {
    @Id
    private String id;

    private Long seq;
}

