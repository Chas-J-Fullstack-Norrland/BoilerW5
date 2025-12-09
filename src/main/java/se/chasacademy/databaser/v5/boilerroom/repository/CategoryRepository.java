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


    /* Run these in application
    System.out.println("CategoryName: Total");
        List<Map<String, Object>> rows = categoryRepository.CountBooksPerCategoryAll();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });

        System.out.println("Library: CategoryName: Total");
        rows = categoryRepository.CountBooksPerCategoryAndLibrary();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });
     */


    public List<Map<String, Object>> CountBooksPerCategoryAll(){

        return jdbcClient.sql(
                "Select categoryname,Count(*) as total\n" +
                        "from categoryJunc\n" +
                        "Inner join category on category.categoryid = categoryjunc.categoryid\n" +
                        "group by categoryname\n" +
                        "order by categoryname")
                .query().listOfRows();
    }

    public List<Map<String, Object>> CountBooksPerCategoryAndLibrary(){

        return jdbcClient.sql(
                        "Select adress,categoryname,Count(*) as total\n" +
                                "from categoryJunc\n" +
                                "Inner join category on category.categoryid = categoryjunc.categoryid\n" +
                                "Inner join bookcopy on categoryjunc.bookid = bookcopy.bookid\n" +
                                "Inner join library on bookcopy.LibraryID = library.libraryID\n" +
                                "group by categoryname,adress\n" +
                                "order by adress")
                .query().listOfRows();
    }





}
