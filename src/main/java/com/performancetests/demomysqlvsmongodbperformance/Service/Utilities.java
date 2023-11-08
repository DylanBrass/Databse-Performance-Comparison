package com.performancetests.demomysqlvsmongodbperformance.Service;

import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoPostRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MongoDB.MongoUserRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlPostRepo;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlUser;
import com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL.SqlUserRepo;
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
    @Autowired
    SqlUserRepo sqlUserRepo;
    @Autowired
    MongoPostRepo mongoPostRepo;
    @Autowired
    SqlPostRepo sqlPostRepo;
    @Autowired
    MongoUserRepo mongoUserRepo;
    public void clear() {
        mongoRepo.deleteAll();
        mySQLRepo.deleteAll();
        sqlUserRepo.deleteAll();
        mongoPostRepo.deleteAll();
        sqlPostRepo.deleteAll();
        mongoUserRepo.deleteAll();

    }
}
