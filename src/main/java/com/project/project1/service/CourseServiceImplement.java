package com.project.project1.service;

import com.project.project1.exceptions.ObjectNotFoundException;
import com.project.project1.model.Course;
import com.project.project1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplement implements CourseService{

    CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplement(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new LinkedList<>();
        courseRepository.findAll().iterator().forEachRemaining(courses::add);
        return courses;
    }

    @Override
    public Course findById(int id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (!courseOptional.isPresent())
        {
            throw new ObjectNotFoundException("Course not found!");
        }
        return courseOptional.get();
    }

    @Override
    public Course addCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);

    }
}
