package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoPostRepo extends MongoRepository<MongoPost, String> {
    List<MongoPost> findAllByUserId(String userId);
}
