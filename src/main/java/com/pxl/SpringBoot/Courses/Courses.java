package com.pxl.SpringBoot.Courses;

import com.pxl.SpringBoot.Student.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    private LocalDate dateStart;
    private String link;
    private Boolean certificate;
    @ManyToMany(mappedBy = "completedCourses")
    private List<Student> completedByStudents = new ArrayList<>();
    public void addStudent(Student student){
        completedByStudents.add(student);
    }

    public Courses() {

    }

    public Courses(Long id,
                   String title,
                   LocalDate dateStart,
                   String link,
                   Boolean certificate) {
        this.id = id;
        this.title = title;
        this.dateStart = dateStart;
        this.link = link;
        this.certificate = certificate;
    }

    public Courses(String title,
                   LocalDate dateStart,
                   String link,
                   Boolean certificate) {
        this.title = title;
        this.dateStart = dateStart;
        this.link = link;
        this.certificate = certificate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public String link() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getCertificate() {
        return certificate;
    }
    public void setCertificate(Boolean certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateStart=" + dateStart +
                ", link=" + link +
                ", certificate=" + certificate +
                '}';
    }


}
