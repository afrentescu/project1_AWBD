package com.project.project1.controllers;

import com.project.project1.controller.DormitoriesController;
import com.project.project1.controller.StudentsController;
import com.project.project1.model.Dormitory;
import com.project.project1.model.Student;
import com.project.project1.service.DormitoryService;
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

public class DormitoryControllerTest {

    @Mock
    Model model;

    @Mock
    DormitoryService dormitoryService;
    DormitoriesController dormitoriesController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        dormitoriesController = new DormitoriesController(dormitoryService);
    }

    @Test
    public void checkInsertedId() {
        int id = 1;
        Dormitory testDormitory = new Dormitory();
        testDormitory.setId(id);
        when(dormitoryService.findById(id)).thenReturn(testDormitory);
        String viewName = dormitoriesController.showById(String.valueOf(id), model);
        Assert.assertEquals("dormitoryInfo", viewName);
        verify(dormitoryService, times(1)).findById(id);
        ArgumentCaptor<Dormitory> argumentCaptor = ArgumentCaptor.forClass(Dormitory.class);
        verify(model, times(1)).addAttribute(eq("dormitory"), argumentCaptor.capture() );
        Dormitory dormitoryArg = argumentCaptor.getValue();
        Assert.assertEquals(dormitoryArg.getId(), testDormitory.getId() );

    }
}
