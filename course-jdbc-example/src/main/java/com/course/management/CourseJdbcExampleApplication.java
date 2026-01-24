package com.course.management;

import com.course.management.dao.CategoryDao;
import com.course.management.entites.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseJdbcExampleApplication implements CommandLineRunner {


	@Autowired
	private CategoryDao categoryDao;
	public static void main(String[] args) {
		SpringApplication.run(CourseJdbcExampleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started....");
			//category create karne jaa rahe hai

		/*    Category category = new Category();
		category.setId(102);
		category.setName("Live Batch");
		category.setDescription("This is live batch category");

		Category savedCategory = categoryDao.save(category);
		System.out.println("category created with id  " + savedCategory.getId());
               */

	/*	List<Category> categories = categoryDao.getAll();
		categories.forEach(cat -> {
			System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getDescription());
		});
		*/


//		Category category = categoryDao.get(101);
//		System.out.println(category.getName());


		categoryDao.delete(102);

	}
}
