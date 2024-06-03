package com.example.homework_dao_hibernate.controller;

import com.example.homework_dao_hibernate.entity.Person;
import com.example.homework_dao_hibernate.repository.PersonJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonJpaRepository personJpaRepository;

    public PersonController(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    @GetMapping("/persons/by-city")
    List<Person> getPersons(@RequestParam("city") String city) {
        return personJpaRepository.findAllByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age-younger-than/{age}")
    List<Person> getPersonsYoungerThan(@PathVariable("age") int age) {
        return personJpaRepository.findByKey_AgeLessThanOrderByKey_AgeAsc(age);
    }

    @GetMapping("/persons")
    Optional<Person> getPersonByNameSurname(@RequestParam(name = "name") String name, @RequestParam(name = "surname") String surname) {
        return personJpaRepository.findAllByKey_NameAndKey_Surname(name.toLowerCase(), surname.toLowerCase());
    }
}
