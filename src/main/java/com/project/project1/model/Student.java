package com.project.project1.model;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Please enter the first name!")
    private String firstName;

    @NotNull(message = "Please enter the last name!")
    private String lastName;
    private String email;

    public Student(){

    }



    @ManyToOne
     private Dormitory studDormitory;


    @ManyToMany(mappedBy = "courseStudents", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> courses;

    @ManyToMany(mappedBy = "examStudents", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Exam> exams;


    @ManyToOne
    private Department studentDep;

    @OneToMany(mappedBy = "studentGrade", cascade = CascadeType.ALL)
    private List<Grades> grades;

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Dormitory getStudDormitory() {
        return studDormitory;
    }

    public void setStudDormitory(Dormitory studDormitory) {
        this.studDormitory = studDormitory;
    }

    public List<Course> getStudentCourses() {
        return courses;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.courses = studentCourses;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Department getStudentDep() {
        return studentDep;
    }

    public void setStudentDep(Department studentDep) {
        this.studentDep = studentDep;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void removeCourse(Course course) {
        course.getCourseStudents().remove(this);
        courses.remove(course);
    }

    public void removeExam(Exam exam) {
        exam.getExamStudents().remove(this);
        exams.remove(exam);
    }
}
