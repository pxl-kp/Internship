package com.pxl.SpringBoot.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesRepository
        extends CrudRepository<Courses, Long> {
    @Query("SELECT s from Courses s WHERE s.title=?1") // SELECT * FROM student WHERE email = ? | JBQL I guess
    Optional<Courses> findCoursesByTitle(String title);
}
