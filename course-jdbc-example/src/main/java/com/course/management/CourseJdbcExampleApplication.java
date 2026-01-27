package com.course.management;

import com.course.management.dao.CategoryDao;
import com.course.management.dao.CourseDao;
import com.course.management.entites.Category;
import com.course.management.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private CourseDao courseDao;

	public static void main(String[] args) {
		SpringApplication.run(CourseJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Application started....");

		// ================= CATEGORY =================

//        Category category = new Category();
//        category.setName("Live Batch");
//        category.setDescription("This is live batch category");
//        Category savedCategory = categoryDao.save(category);
//        System.out.println("Category created with id " + savedCategory.getId());

//        List<Category> categories = categoryDao.getAll();
//        categories.forEach(cat ->
//                System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getDescription())
//        );

//        Category category = categoryDao.get(101);
//        System.out.println(category.getName());

//        categoryDao.delete(102);

		// ================= COURSE =================

//        Course course = new Course();
//        course.setTitle("Spring Boot Course");
//        course.setDescription("THIS IS FIRST COURSE");
//        course.setPrice(5000);
//        course.setCategoryId(101);
//        courseDao.save(course);

		Course course = courseDao.get(1);
		if (course != null) {
			System.out.println(course.getTitle() + " " + course.getDescription());
		} else {
			System.out.println("Course not found");
		}
	}
}
