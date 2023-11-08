package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SqlPostRepo extends CrudRepository<SqlPost, Long> {
    List<SqlPost> findAllBySqlUser(SqlUser sqlUser);
}
