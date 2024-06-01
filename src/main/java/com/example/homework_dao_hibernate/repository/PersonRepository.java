package com.example.homework_dao_hibernate.repository;

import com.example.homework_dao_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        List<Person> persons = entityManager.createQuery("select p from Person p", Person.class).getResultList();
        return persons.stream().filter(p -> city.equals(p.getCityOfLiving())).collect(Collectors.toList());
    }
}
