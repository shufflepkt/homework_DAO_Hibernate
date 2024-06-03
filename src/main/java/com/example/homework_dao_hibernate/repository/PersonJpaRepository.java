package com.example.homework_dao_hibernate.repository;

import com.example.homework_dao_hibernate.entity.Key;
import com.example.homework_dao_hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Key> {
    @Query("select p from Person p where p.cityOfLiving = :cityOfLiving")
    List<Person> findAllByCityOfLiving(@Param("cityOfLiving") String cityOfLiving);

    @Query("select p from Person p where p.key.age < :age order by p.key.age")
    List<Person> findByKey_AgeLessThanOrderByKey_AgeAsc(@Param("age") int age);

    @Query("select p from Person p where lower(p.key.name) = :name and lower(p.key.surname) = :surname")
    Optional<Person> findAllByKey_NameAndKey_Surname(@Param("name") String name, @Param("surname") String surname);
}
