package se.chasacademy.databaser.v5.boilerroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.v5.boilerroom.models.Person;
import se.chasacademy.databaser.v5.boilerroom.repository.mapper.PersonRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {


    private JdbcClient jdbcClient;



    private final PersonRowMapper personRowMapper = new PersonRowMapper();

    // Hämta alla personer
    public List<Person> findAll() {
        return jdbcClient.sql("SELECT personid, personname, adress, phonenumber FROM person")
                .query(Person.class)  // magi – mappar direkt till record!
                .list();
    }


    // Hämta efter ID
    public Optional<Person> findById(int id) {
        return jdbcClient.sql("SELECT personid, personname, adress, phonenumber FROM person WHERE person_id = :id")
                .param("id", id)
                .query(Person.class)
                .optional();
    }



}
