package se.chasacademy.databaser.v5.boilerroom.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    private JdbcClient jdbcClient;

    public CategoryRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }





}
