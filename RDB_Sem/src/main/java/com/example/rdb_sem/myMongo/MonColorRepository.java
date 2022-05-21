package com.example.rdb_sem.myMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MonColorRepository extends MongoRepository<MonColor,String> {

}
