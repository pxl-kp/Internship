package com.pxl.SpringBoot.Courses;

import com.pxl.SpringBoot.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
    @Query("SELECT s from Courses s WHERE s.title=?1") // SELECT * FROM student WHERE email = ? | JBQL I guess
    Optional<Courses> findCoursesByTitle(String email);
}
