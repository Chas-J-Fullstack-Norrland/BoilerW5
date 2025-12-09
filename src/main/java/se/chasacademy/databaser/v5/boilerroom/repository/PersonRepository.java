package se.chasacademy.databaser.v5.boilerroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.v5.boilerroom.models.Person;
import se.chasacademy.databaser.v5.boilerroom.repository.mapper.PersonRowMapper;

import java.util.List;

@Repository
public class PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final PersonRowMapper personRowMapper = new PersonRowMapper();

    // Hämta alla personer
    public List<Person> findAll() {
        String sql = "SELECT personid, personname, adress, phonenumber FROM person";
        return jdbcTemplate.query(sql, personRowMapper);
    }

    // Hämta person efter ID
    public Person findById(int id) {
        String sql = "SELECT personid, personname, adress, phonenumber FROM person WHERE personid = ?";
        return jdbcTemplate.queryForObject(sql, personRowMapper, id);
    }
}
