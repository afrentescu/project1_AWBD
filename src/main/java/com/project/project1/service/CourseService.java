package com.project.project1.service;

import com.project.project1.model.Course;
import com.project.project1.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<Course> findAll();
    Course findById(int id);
    Course addCourse(Course course);
    void deleteById(int id);
}
