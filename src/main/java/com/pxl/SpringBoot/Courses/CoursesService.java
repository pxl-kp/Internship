package com.pxl.SpringBoot.Courses;

import com.pxl.SpringBoot.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CoursesService {
    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesService(CoursesRepository coursesRepository){
        this.coursesRepository = coursesRepository;
    }

    public List<Courses> getCourses(){
        return (List<Courses>) coursesRepository.findAll();
    }

    public void addNewCourse(Courses course){
        Optional<Courses> coursesOptional = coursesRepository
                .findCoursesByTitle(course.getTitle());
        if(coursesOptional.isPresent()) {
            throw new IllegalStateException("This course already exists");
        }
        coursesRepository.save(course);
    }

    public void deleteCourse(Long courseId){
        boolean exists = coursesRepository.existsById(courseId);
        if(!exists){
            throw new IllegalStateException(
                    "Course with ID " + courseId + " does not exist"
            );
        }
        coursesRepository.deleteById(courseId);
    }

    @Transactional
    public ResponseEntity<Courses> updateCourse(Long courseId, String title){
        Courses _course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Course with id = " + courseId));

        if(title != null &&
            title.length() > 0 &&
            !Objects.equals(_course.getTitle(), title)) {
                Optional<Courses> coursesOptional = coursesRepository
                        .findCoursesByTitle(title);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
