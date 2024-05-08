package com.example.yazlab3_mongo.Services;

import com.example.yazlab3_mongo.Repository.SequenceRepo;
import com.example.yazlab3_mongo.entities.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
    @Autowired
    private MongoOperations mongoOperations;

    private SequenceRepo sequenceRepo;

    public SequenceGeneratorService(MongoOperations mongoOperations, SequenceRepo sequenceRepo) {
        this.mongoOperations = mongoOperations;
        this.sequenceRepo = sequenceRepo;
    }

    public Long getSquenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq",1);
        DatabaseSequence databaseSequence = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DatabaseSequence.class);
        return !Objects.isNull(databaseSequence) ? databaseSequence.getSeq() : 1;
    }

    public void deleteAllSequence(){
        sequenceRepo.deleteAll();
    }
}

