package com.project.project1.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.project.project1.model.Course;
import com.project.project1.model.Department;
import com.project.project1.model.Professor;
import com.project.project1.repository.CourseRepository;
import com.project.project1.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Slf4j
public class CourseRepositoryTest {


    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void addCourse()
    {
        Course course = new Course();
        course.setDescription("You will learn about...");
        course.setName("Could computing");
        courseRepository.save(course);
    }


    @Test
    public void findAllCoures() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        assertTrue(courses.size() >= 3);
        log.info("findAllCourses ...");
        courses.forEach(course -> log.info(String.valueOf(course.getId())));
    }

    @Test
    public void findById() {
        Course course = courseRepository.findCourseById(2);
        assertFalse(course.equals(null));

    }

    @Test
    public void deleteById(){
        courseRepository.deleteById(8);
        assertThat(courseRepository.count()).isEqualTo(7);
    }
}
