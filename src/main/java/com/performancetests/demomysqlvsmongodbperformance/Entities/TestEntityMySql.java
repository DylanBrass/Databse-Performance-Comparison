package com.performancetests.demomysqlvsmongodbperformance.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@Entity
@Table(name = "tests")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestEntityMySql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "test_string")
    public String testString;
    @Column(name = "test_int")
    public int testInt;
    @Column(name = "test_float")
    public float testFloat;
    @Column(name = "test_boolean")
    public boolean testBoolean;
    @Column(name = "test_date")
    public LocalDate testDate;
}
