package com.performancetests.demomysqlvsmongodbperformance.repos;

import com.performancetests.demomysqlvsmongodbperformance.Entities.TestEntityMySql;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface MySQLRepo extends CrudRepository<TestEntityMySql,String> {
    }
