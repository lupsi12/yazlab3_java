package com.example.yazlab3_mongo.Repository;

import com.example.yazlab3_mongo.entities.Calc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CalcRepo extends MongoRepository<Calc, Long> {
    List<Calc> findByUserId(Optional<Long> userId);
}
