package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    /*public List<Person> findAll() {
        return entityManager.find
    }

    public int deleteById(int personId) {
    }

    public int updatePerson(Person person) {
    }

    public int createPerson(Person person) {
    }*/
}
