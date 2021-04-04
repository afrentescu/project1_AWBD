package com.project.project1.service;

import com.project.project1.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    Student addStudent(Student student);
    void deleteById(int id);
    List<Student>  findByDepartment(int departmentId);
    List<Student> findByDormitory(int id);

}
