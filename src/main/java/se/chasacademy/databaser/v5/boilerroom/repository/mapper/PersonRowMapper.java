package se.chasacademy.databaser.v5.boilerroom.repository.mapper;


import se.chasacademy.databaser.v5.boilerroom.models.Person;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setPersonId(rs.getInt("person_id"));
        person.setName(rs.getString("name"));
        person.setAdress(rs.getString("address"));
        person.setPhoneNumber(rs.getString("phone_number"));
        return person;
    }
}
