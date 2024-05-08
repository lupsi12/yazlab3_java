package com.example.yazlab3_mongo.Repository;

import com.example.yazlab3_mongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User, Long> {
    List<User> findByEmailAndPassword(String email,String password);
    List<User> findByEmail(String email);

}
