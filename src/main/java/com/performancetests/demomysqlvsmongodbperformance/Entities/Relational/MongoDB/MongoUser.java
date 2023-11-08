package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
@Builder
@Getter
public class MongoUser {
    @Id
    private String id;
    private String username;
    private List<String> postIds;

    // Getters and setters
}


