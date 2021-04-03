package com.project.project1.repository;

import com.project.project1.model.Course;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findCourseById(int id);
    void deleteById(int id);
}
