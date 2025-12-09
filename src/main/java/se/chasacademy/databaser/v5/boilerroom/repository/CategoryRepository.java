package se.chasacademy.databaser.v5.boilerroom.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import se.chasacademy.databaser.v5.boilerroom.models.Category;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class CategoryRepository {
    private JdbcClient jdbcClient;

    public CategoryRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Map<String, Object>> CountBooksPerCategoryAll(){

        return jdbcClient.sql(
                "Select categoryType,Count(*) as total " +
                "from categoryJunc" +
                "Inner join category on category.categoryid = categoryjunc.categoryid" +
                "order by categoryType")
                .query().listOfRows();

    }





}
