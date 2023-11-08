package com.performancetests.demomysqlvsmongodbperformance.Entities.Relational.MySQL;

import org.springframework.data.repository.CrudRepository;

public interface SqlUserRepo extends CrudRepository<SqlUser, Long> {
}
