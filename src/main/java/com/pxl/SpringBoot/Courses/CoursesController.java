package com.pxl.SpringBoot.Courses;

import com.pxl.SpringBoot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CoursesController {
    private final CoursesService coursesService;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    public CoursesController (CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @GetMapping
    public ResponseEntity<List<Courses>> getCourses(@RequestParam(required = false) String title) {
        List<Courses> courses = new ArrayList<Courses>();

        if (title == null)
            coursesRepository.findAll().forEach(courses::add);
        else
            coursesRepository.findCoursesByTitle(title);

        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Courses>>(coursesService.getCourses(), HttpStatus.OK);
    }

    @PostMapping
    public void addNewCourse (@RequestBody Courses course){
        coursesService.addNewCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(
            @PathVariable("courseId") Long courseId){
        coursesService.deleteCourse(courseId);
    }

    @PutMapping(path = "{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestParam(required = false) String title){
        coursesService.updateCourse(courseId, title);
    }


}
