package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepo extends MongoRepository<MongoUser, String> {
}
