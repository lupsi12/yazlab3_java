package com.example.yazlab3_mongo.Repository;

import com.example.yazlab3_mongo.entities.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepo extends MongoRepository<DatabaseSequence, String> {
}
