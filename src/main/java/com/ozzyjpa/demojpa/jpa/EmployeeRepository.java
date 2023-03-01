package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Course;
import com.ozzyjpa.demojpa.entity.Employee;
import com.ozzyjpa.demojpa.entity.FullTimeEmployee;
import com.ozzyjpa.demojpa.entity.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional // so that db operations are not left unfinished
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployees(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    // for @MappedSuperclass
    public List<PartTimeEmployee> retrieveAllPartTimeEmployees(){
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }
    // for @MappedSuperclass
    public List<FullTimeEmployee> retrieveAllFullTimeEmployees(){
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }


}
