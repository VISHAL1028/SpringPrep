package com.course.management.dao;

import com.course.management.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE
    public Course save(Course course) {
        String sql = "INSERT INTO courses(title, description, price, category_id) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, course.getTitle());
            ps.setString(2, course.getDescription());
            ps.setInt(3, course.getPrice());
            ps.setInt(4, course.getCategoryId());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            course.setCourseId(keyHolder.getKey().intValue());
        }
        return course;
    }

    // READ ALL
    public List<Course> getAll() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course c = new Course();
            c.setCourseId(rs.getInt("courseId"));
            c.setTitle(rs.getString("title"));
            c.setDescription(rs.getString("description"));
            c.setPrice(rs.getInt("price"));
            c.setCategoryId(rs.getInt("category_id"));
            return c;
        });
    }

    // READ ONE
    public Course get(int courseId) {
        String sql = "SELECT * FROM courses WHERE courseId = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Course c = new Course();
            c.setCourseId(rs.getInt("courseId"));
            c.setTitle(rs.getString("title"));
            c.setDescription(rs.getString("description"));
            c.setPrice(rs.getInt("price"));
            c.setCategoryId(rs.getInt("category_id"));
            return c;
        }, courseId);
    }

    // UPDATE
    public Course update(Course course) {
        String sql = "UPDATE courses SET title=?, description=?, price=?, category_id=? WHERE courseId=?";
        int rows = jdbcTemplate.update(
                sql,
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getCategoryId(),
                course.getCourseId()
        );
        return rows > 0 ? course : null;
    }

    // DELETE
    public boolean delete(int courseId) {
        String sql = "DELETE FROM courses WHERE courseId=?";
        return jdbcTemplate.update(sql, courseId) > 0;
    }

    // READ BY CATEGORY
    public List<Course> getByCategoryId(int categoryId) {
        String sql = "SELECT * FROM courses WHERE category_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course c = new Course();
            c.setCourseId(rs.getInt("courseId"));
            c.setTitle(rs.getString("title"));
            c.setDescription(rs.getString("description"));
            c.setPrice(rs.getInt("price"));
            c.setCategoryId(rs.getInt("category_id"));
            return c;
        }, categoryId);
    }
}
