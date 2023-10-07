package com.performancetests.demomysqlvsmongodbperformance.Service;

import com.performancetests.demomysqlvsmongodbperformance.repos.MongoRepo;
import com.performancetests.demomysqlvsmongodbperformance.repos.MySQLRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Utilities {

    @Autowired
    MongoRepo mongoRepo;
    @Autowired
    MySQLRepo mySQLRepo;

    public void clear() {
        mongoRepo.deleteAll();
        mySQLRepo.deleteAll();
    }
}
