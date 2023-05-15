package com.pxl.SpringBoot.Courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CoursesController {
    private final CoursesService coursesService;
    @Autowired
    public CoursesController (CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @GetMapping
    public List<Courses> getCourses(){
        return coursesService.getCourses();
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
