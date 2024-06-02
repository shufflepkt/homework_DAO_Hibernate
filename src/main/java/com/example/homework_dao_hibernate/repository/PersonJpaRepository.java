package com.example.homework_dao_hibernate.repository;

import com.example.homework_dao_hibernate.entity.Key;
import com.example.homework_dao_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Key> {
    List<Person> findAllByCityOfLiving(String cityOfLiving);
    List<Person> findByKey_AgeLessThanOrderByKey_AgeAsc(int age);
    Optional<Person> findAllByKey_NameAndKey_Surname(String name, String surname);
}
