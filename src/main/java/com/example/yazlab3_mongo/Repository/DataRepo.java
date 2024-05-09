package com.example.yazlab3_mongo.Repository;

import com.example.yazlab3_mongo.entities.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepo extends MongoRepository<Data, Long> {
}
