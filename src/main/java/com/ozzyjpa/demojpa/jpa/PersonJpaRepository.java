package com.ozzyjpa.demojpa.jpa;

import com.ozzyjpa.demojpa.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }

    public Person updatePerson(Person person) {
        return entityManager.merge(person);
    }

    public Person insertPerson(Person person) {
        return entityManager.merge(person);
    }
}
