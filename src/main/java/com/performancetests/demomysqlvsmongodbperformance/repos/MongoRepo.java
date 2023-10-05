package com.performancetests.demomysqlvsmongodbperformance.repos;

import com.performancetests.demomysqlvsmongodbperformance.Entities.TestEntityMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<TestEntityMongo, String> {

}
