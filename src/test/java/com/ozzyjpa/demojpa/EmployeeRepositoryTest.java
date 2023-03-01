package com.ozzyjpa.demojpa;


import com.ozzyjpa.demojpa.entity.FullTimeEmployee;
import com.ozzyjpa.demojpa.entity.PartTimeEmployee;
import com.ozzyjpa.demojpa.jpa.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.math.BigDecimal;


@SpringBootTest
public class EmployeeRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void insertEmployee() {
       employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
       employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

       logger.info("All employees -> {}", employeeRepository.retrieveAllEmployees());
    }

    @Test
    void insertPartTimeEmployee() {
        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

        logger.info("FullTimeEmployees  -> {}", employeeRepository.retrieveAllFullTimeEmployees());
        logger.info("PartTimeEmployees  -> {}", employeeRepository.retrieveAllPartTimeEmployees());
    }

}
