package com.course.management.dao;

import com.course.management.entites.Category;
import com.course.management.utils.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CategoryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

@PostConstruct
    public void init(){
    String createTableQuery =
            "CREATE TABLE IF NOT EXISTS categories (" +
                    "id INT PRIMARY KEY, " +
                    "title VARCHAR(50) NOT NULL, " +
                    "description VARCHAR(200)" +
                    ")";

    jdbcTemplate.execute(createTableQuery);
    System.out.println("Category table created");

}

//    create Table

//    save Category
    public Category save(Category category) {
        /*   parameterized query*/
            String query= "insert into categories(id,title,description) values(?,?,?)";
            int rows = jdbcTemplate.update(query,
                    category.getId(),
                    category.getName(),
                    category.getDescription());
        System.out.println(rows+"effected");
        return category;
    }

//    update Category
    public Category update(int categoryId,Category newCat){
        String query="update categories set title=?, description=? WHERE id=?";
     int update =   jdbcTemplate.update(query,
             newCat.getName(),
             newCat.getDescription(),
             categoryId);
        System.out.println(update+" rows updated");
        newCat.setId(update);

        return newCat;

    }
//    get  all Category

    public List<Category> getAll(){
       String query="select * from categories";
//         List<Category> categories = jdbcTemplate.queryForList(query,Category.class);
        List<Category> categories=jdbcTemplate.query(query,new CategoryRowMapper());
         return categories;
    }
//    get single Category by id
    public Category get(int categoryId){
    String query= "select * from categories where id=?";
//    Category category = jdbcTemplate.queryForObject(query,Category.class,categoryId);

        return  jdbcTemplate.queryForObject(query,new CategoryRowMapper(),categoryId);
    }
//    delete Category
    public void delete(int categoryId){
    String query="delete from categories where id=?";
     jdbcTemplate.update(query,categoryId);
    }
}
