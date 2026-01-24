package com.course.management.utils;

import com.course.management.entites.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper <Category> {
//    logic to convert table row to Category object
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("title"));
        category.setDescription(rs.getString("description"));
        return category;

    }


}
