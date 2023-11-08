package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class MongoPost {
    @Id
    private String id;
    private String title;
    private String content;
    private String userId; // Reference to the User who created the post

    // Getters and setters
}
