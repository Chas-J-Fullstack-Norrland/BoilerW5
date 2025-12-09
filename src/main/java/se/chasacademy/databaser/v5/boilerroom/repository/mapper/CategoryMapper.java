package se.chasacademy.databaser.v5.boilerroom.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import se.chasacademy.databaser.v5.boilerroom.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {


    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();

        category.setId(rs.getInt("categoryID"));
        category.setType(rs.getString("categoryType"));

        return category;


    }
}
