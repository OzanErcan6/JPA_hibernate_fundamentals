package com.ozzyjpa.demojpa;

import com.ozzyjpa.demojpa.entity.Person;
import com.ozzyjpa.demojpa.jdbc.PersonJdbcDao;
import com.ozzyjpa.demojpa.jpa.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Controller {

    @Autowired
    //PersonJdbcDao dao;
    PersonJpaRepository dao;

    /*@GetMapping
    public List<Person> getAllPersons() {
        return dao.findAll();
    }*/


    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable int personId){
        return dao.findById(personId);
    }

    /*@DeleteMapping("/{personId}")
    public int deletePersonByPersonId(@PathVariable int personId){
         return dao.deleteById(personId);
    }

    @PutMapping
    public int updatePersonByPersonId(@RequestBody Person person){
        return dao.updatePerson(person);
    }

    @PostMapping
    public int createPost(@RequestBody Person person){
        return dao.createPerson(person);
    }*/
}
