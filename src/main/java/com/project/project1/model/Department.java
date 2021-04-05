package com.project.project1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Please enter the name of the department!")
    private String name;

    @OneToMany(mappedBy = "studentDep")
    private List<Student> departementStudents;

    @OneToMany(mappedBy = "professorDep", cascade = CascadeType.ALL)
    List<Professor> departmentProfessors;

    public Department(){

    }


    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Student> getDepartementStudents() {
        return departementStudents;
    }

    public void setDepartementStudents(List<Student> departementStudents) {
        this.departementStudents = departementStudents;
    }

    public List<Professor> getDepartmentProfessors() {
        return departmentProfessors;
    }

    public void setDepartmentProfessors(List<Professor> departmentProfessors) {
        this.departmentProfessors = departmentProfessors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
