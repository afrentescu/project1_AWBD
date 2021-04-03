package com.project.project1.services;

import com.project.project1.model.Department;
import com.project.project1.model.Student;
import com.project.project1.repository.DepartmentRepository;
import com.project.project1.repository.StudentRepository;
import com.project.project1.service.DepartmentService;
import com.project.project1.service.DepartmentServiceImplement;
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

public class DepartmentServicetest {

    DepartmentService departmentService;

    @Mock
    DepartmentRepository departmentRepository;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        departmentService = new DepartmentServiceImplement(departmentRepository);
    }
    @Test
    public void findAllDepartments() {
        List<Department> departments = new ArrayList<Department>();
        Department department = new Department();
       department.setId(1);
       department.setName("Medicine");
        departments.add(department);
        when(departmentRepository.findAll()).thenReturn(departments);
        List<Department> allSDepartments = departmentService.findAll();
        assertEquals(allSDepartments.size(), 1);
        verify(departmentRepository, times(1)).findAll();}
}
