package com.pxl.SpringBoot.Courses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration //bean
public class CoursesConfig {

    @Bean
    CommandLineRunner commandLineRunnerCourses(CoursesRepository repository) {
        return args -> {
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

            //itvdn.addStudent(sasha);
            //SpringBoot.addStudent(sasha);
            //SpringBoot.addStudent(vika);
            //w3school.addStudent(vika);

            repository.saveAll(
                    List.of(itvdn, w3school, SpringBoot)
            );
        };
    }
}
