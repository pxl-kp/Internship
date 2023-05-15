package com.pxl.SpringBoot.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends CrudRepository<Student, Long> {   // Data access
    @Query("SELECT s from Student s WHERE s.email=?1") // SELECT * FROM student WHERE email = ? | JBQL I guess
    Optional<Student> findStudentByEmail(String email);
}
