package com.performancetests.demomysqlvsmongodbperformance.Entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDate;

@Document(collection = "tests")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestEntityMongo {

    @Id
    private String id;
    private String testString;
    private int testInt;
    private float testFloat;
    private boolean testBoolean;
    private LocalDate testDate;

}
