package com.project.project1.model;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "You should enter the name of the course!")
    private String name;

    @NotNull(message = "Please enter the highlights of the course!")
    private String description;


    @OneToOne
    private Exam exam;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})@JoinTable(name="course_students", joinColumns = @JoinColumn ( name="course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student>  courseStudents;


    @ManyToOne
    private Professor courseTeacher;

    public Course(){

    }

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    public Professor getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Professor courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void removeStudent(Student student) {
        student.getCourses().remove(this);
        courseStudents.remove(student);
    }
}
