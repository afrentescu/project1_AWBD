package com.project.project1.controllers;

import com.project.project1.controller.CourseController;
import com.project.project1.model.Course;
import com.project.project1.service.CourseService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

public class CourseControllerTest {

    @Mock
    Model model;

    @Mock
    CourseService courseService;
    CourseController courseController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        courseController = new CourseController(courseService);
    }

    @Test
    public void checkInsertedId() {
        int id = 1;
        Course testCourse = new Course();
        testCourse.setId(id);
    when(courseService.findById(id)).thenReturn(testCourse);
    String viewName = courseController.showById(String.valueOf(id), model);
    Assert.assertEquals("courseInfo", viewName);
    verify(courseService, times(1)).findById(id);
    ArgumentCaptor<Course> argumentCaptor = ArgumentCaptor.forClass(Course.class);
    verify(model, times(1)).addAttribute(eq("course"), argumentCaptor.capture() );
    Course courseArg = argumentCaptor.getValue();
    Assert.assertEquals(courseArg.getId(), testCourse.getId() );

    }


}
