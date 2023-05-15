package com.pxl.SpringBoot.Courses;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
        return coursesRepository.findAll();
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
    public void updateCourse(Long courseId,
                             String title){
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException(
                        "Course with ID " + courseId + " does not exist"));

        if(title != null &&
            title.length() > 0 &&
            !Objects.equals(course.getTitle(), title)) {
                Optional<Courses> coursesOptional = coursesRepository
                        .findCoursesByTitle(title);
            course.setTitle(title);
        }
    }

}
