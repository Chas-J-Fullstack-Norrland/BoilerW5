package se.chasacademy.databaser.v5.boilerroom.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {
    private final JdbcClient jdbcClient;

    public AuthorRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
}
