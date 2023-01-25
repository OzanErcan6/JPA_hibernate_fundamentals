package com.ozzyjpa.demojpa.jdbc;

import com.ozzyjpa.demojpa.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

//@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate template;
/*
    //select * from person
    public List<Person> findAll(){
       return template.query("select * from Person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    //select * from person
    public Person findById(int id){
        return template.queryForObject("select * from Person where id=?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
         return template.update("delete from Person where id=?", new Object[]{id} );

    }

    public int updatePerson(Person person) {
        return template.update("update person set name = ?, location = ?, birth_date = ? where id = ?",
            new Object[]{
                    person.getName(),
                    person.getLocation(),
                    new Timestamp(person.getBirthDate().getTime()),
                    person.getId()} );

    }


    public int createPerson(Person person) {
        return template.update("insert into person (id, name, location, birth_date) values(?,?,?,?)",
                new Object[]{person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())} );

    }*/
}
