package com.project.project1.controllers;

import com.project.project1.controller.DepartmentController;
import com.project.project1.controller.DormitoriesController;
import com.project.project1.controller.StudentsController;
import com.project.project1.model.Department;
import com.project.project1.model.Dormitory;
import com.project.project1.model.Student;
import com.project.project1.service.DepartmentService;
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

public class DepartmentControllerTest {

    @Mock
    Model model;

    @Mock
    DepartmentService departmentService;
    DepartmentController departmentController;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        departmentController = new DepartmentController(departmentService);
    }

    @Test
    public void checkInsertedId() {
        int id = 1;
        Department testDep = new Department();
        testDep.setId(id);
        when(departmentService.findById(id)).thenReturn(testDep);
        String viewName = departmentController.showById(String.valueOf(id), model);
        Assert.assertEquals("departmentInfo", viewName);
        verify(departmentService, times(1)).findById(id);
        ArgumentCaptor<Department> argumentCaptor = ArgumentCaptor.forClass(Department.class);
        verify(model, times(1)).addAttribute(eq("department"), argumentCaptor.capture() );
        Department depArg = argumentCaptor.getValue();
        Assert.assertEquals(depArg.getId(), testDep.getId() );

    }
}
