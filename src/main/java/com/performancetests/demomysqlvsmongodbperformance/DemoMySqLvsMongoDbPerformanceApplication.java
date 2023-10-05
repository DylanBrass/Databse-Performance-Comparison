package com.performancetests.demomysqlvsmongodbperformance;

import com.performancetests.demomysqlvsmongodbperformance.Entities.TestEntityMySql;
import com.performancetests.demomysqlvsmongodbperformance.Service.StartTest;
import com.performancetests.demomysqlvsmongodbperformance.repos.MySQLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.time.LocalDate;
import java.util.UUID;

@ComponentScans({
        @ComponentScan("com.performancetests.demomysqlvsmongodbperformance.repos"),
        @ComponentScan("com.performancetests.demomysqlvsmongodbperformance.Entities")
})
@SpringBootApplication
public class DemoMySqLvsMongoDbPerformanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMySqLvsMongoDbPerformanceApplication.class, args);

    }
}
