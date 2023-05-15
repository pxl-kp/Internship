package com.pxl.SpringBoot;


import com.pxl.SpringBoot.Courses.Courses;
import com.pxl.SpringBoot.Courses.CoursesRepository;
import com.pxl.SpringBoot.Student.Student;
import com.pxl.SpringBoot.Student.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.time.Month.*;
import static java.time.Month.MAY;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(Application.class, args);
		StudentRepository studentRepository =
				configurableApplicationContext.getBean(StudentRepository.class);
		CoursesRepository coursesRepository =
				configurableApplicationContext.getBean(CoursesRepository.class);

		Student sasha = new Student(
				"Oleksandr",
				"alexander.bodnar@keypartner.com",
				LocalDate.of(2000, APRIL, 1));
		Student vika = new Student(
				"Viktoriia",
				"viktoriia.vlasenko@keypartner.com",
				LocalDate.of(2001, FEBRUARY, 16));
		List<Student> students = Arrays.asList(sasha, vika);

		Courses itvdn = new Courses(
				".NET Development",
				LocalDate.of(2022, MARCH, 20),
				"https://itvdn.com",
				true);
		Courses w3school = new Courses(
				"Java tutorial",
				LocalDate.of(2023, MAY, 9),
				"https://w3school.com",
				true);
		Courses SpringBoot = new Courses(
				"SpringBoot basis",
				LocalDate.of(2023, MAY, 9),
				"https://medium.com",
				false);
		List<Courses> courses = Arrays.asList(itvdn, w3school, SpringBoot);
		coursesRepository.saveAll(courses);

		sasha.addCourse(itvdn);
		sasha.addCourse(SpringBoot);
		vika.addCourse(w3school);
		vika.addCourse(SpringBoot);

		studentRepository.saveAll(students);

	}
}