package com.project.project1.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Please enter the first name!")
    private String firstName;

    @NotNull(message = "Please enter the last name")
    private String lastName;
    private String email;




    @ManyToOne
     private Department professorDep;

     @OneToMany(mappedBy = "courseTeacher", cascade = CascadeType.ALL)
     List<Course> teachedCourses;

    public Professor(){

    }

    public Professor(int id, String firstName, String lastName, String email) {
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

    public Department getProfessorDep() {
        return professorDep;
    }

    public void setProfessorDep(Department professorDep) {
        this.professorDep = professorDep;
    }

    public List<Course> getTeachedCourses() {
        return teachedCourses;
    }

    public void setTeachedCourses(List<Course> teachedCourses) {
        this.teachedCourses = teachedCourses;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
