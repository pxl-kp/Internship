package com.pxl.SpringBoot.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration                      // bean
public class StudentConfig {

    /*@Bean
     CommandLineRunner commandLineRunnerStudents(StudentRepository repository) {
        return args -> {
            Student sasha = new Student(
                    "Oleksandr",
                    "alexander.bodnar@keypartner.com",
                    LocalDate.of(2000, APRIL, 1)
            );

            Student vika = new Student(
                    "Viktoriia",
                    "viktoriia.vlasenko@keypartner.com",
                    LocalDate.of(2001, FEBRUARY, 16)
            );

            //sasha.addCourse(itvdn);
            //sasha.addCourse(SpringBoot);
            //vika.addCourse(SpringBoot);
            //vika.addCourse(w3school);

            repository.saveAll(
                    List.of(sasha, vika)
            );
        };
    }*/
}
