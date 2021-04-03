package com.project.project1.services;

import com.project.project1.model.Course;
import com.project.project1.model.Student;
import com.project.project1.repository.CourseRepository;
import com.project.project1.repository.StudentRepository;
import com.project.project1.service.CourseService;
import com.project.project1.service.CourseServiceImplement;
import com.project.project1.service.StudentService;
import com.project.project1.service.StudentServiceImplement;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CourseServiceTest {

    CourseService courseService;

    @Mock
    CourseRepository courseRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        courseService = new CourseServiceImplement(courseRepository);
    }
    @Test
    public void findAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        Course  course = new Course();
        course.setId(1);
        course.setName("Cloud computing");
        course.setDescription("You will learn about...");
        courses.add(course);
        when(courseRepository.findAll()).thenReturn(courses);
        List<Course> allCourses = courseService.findAll();
        assertEquals(allCourses.size(), 1);
        verify(courseRepository, times(1)).findAll();}
}
