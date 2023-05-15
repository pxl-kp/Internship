package com.pxl.SpringBoot;


import com.pxl.SpringBoot.Courses.CoursesRepository;
import com.pxl.SpringBoot.Student.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(Application.class, args);

		StudentRepository studentRepository =
				configurableApplicationContext.getBean(StudentRepository.class);

		CoursesRepository coursesRepository =
				configurableApplicationContext.getBean(CoursesRepository.class);


	}
}