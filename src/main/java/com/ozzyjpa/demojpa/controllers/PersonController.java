package com.ozzyjpa.demojpa.controllers;

import com.ozzyjpa.demojpa.entity.Person;
import com.ozzyjpa.demojpa.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    //PersonJdbcDao dao;
    PersonJpaRepository dao;

    @GetMapping
    public List<Person> findAllPersons() {
        return dao.findAll();
    }

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable int personId){
        return dao.findById(personId);
    }

    @DeleteMapping("/{personId}")
    public void deletePersonByPersonId(@PathVariable int personId){
         dao.deleteById(personId);
    }

    @PutMapping
    public Person updatePersonByPersonId(@RequestBody Person person){
        return dao.updatePerson(person);
    }

    @PostMapping
    public Person createPost(@RequestBody Person person){
        return dao.insertPerson(person);
    }
}
