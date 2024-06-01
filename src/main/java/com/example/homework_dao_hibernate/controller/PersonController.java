package com.example.homework_dao_hibernate.controller;

import com.example.homework_dao_hibernate.entity.Person;
import com.example.homework_dao_hibernate.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    List<Person> getPersons(@RequestParam("city") String city) {
        return personRepository.getPersonsByCity(city);
    }
}
