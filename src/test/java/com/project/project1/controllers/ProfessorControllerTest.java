package com.project.project1.controllers;

import com.project.project1.controller.ProfessorController;
import com.project.project1.controller.StudentsController;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.service.ProfessorSevrice;
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

public class ProfessorControllerTest {

    @Mock
    Model model;

    @Mock
    ProfessorSevrice professorSevrice;
    ProfessorController professorController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        professorController = new ProfessorController(professorSevrice);
    }

    @Test
    public void checkInsertedId() {
        int id = 1;
        Professor testProf = new Professor();
        testProf.setId(id);
        when(professorSevrice.findById(id)).thenReturn(testProf);
        String viewName = professorController.showById(String.valueOf(id), model);
        Assert.assertEquals("profInfo", viewName);
        verify(professorSevrice, times(1)).findById(id);
        ArgumentCaptor<Professor> argumentCaptor = ArgumentCaptor.forClass(Professor.class);
        verify(model, times(1)).addAttribute(eq("professor"), argumentCaptor.capture() );
        Professor profArg = argumentCaptor.getValue();
        Assert.assertEquals(profArg.getId(), testProf.getId() );

    }
}
