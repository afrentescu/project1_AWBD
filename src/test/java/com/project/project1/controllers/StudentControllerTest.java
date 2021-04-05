package com.project.project1.controllers;

import com.project.project1.controller.CourseController;
import com.project.project1.controller.StudentsController;
import com.project.project1.model.Course;
import com.project.project1.model.Student;
import com.project.project1.service.CourseService;
import com.project.project1.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

    @Mock
    Model model;

    @Mock
    StudentService studentService;
    StudentsController studentController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        studentController = new StudentsController(studentService);
    }

    @Test
    public void checkInsertedId() {
        int id = 1;
        Student testStudent = new Student();
        testStudent.setId(id);
        when(studentService.findById(id)).thenReturn(testStudent);
        String viewName = studentController.showById(String.valueOf(id), model);
        Assert.assertEquals("studentInfo", viewName);
        verify(studentService, times(1)).findById(id);
        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(model, times(1)).addAttribute(eq("student"), argumentCaptor.capture() );
        Student studArg = argumentCaptor.getValue();
        Assert.assertEquals(studArg.getId(), testStudent.getId() );

    }
}
