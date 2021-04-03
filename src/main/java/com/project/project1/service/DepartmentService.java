package com.project.project1.service;

import com.project.project1.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();
    Department findById(int id);
    Department addDepartment(Department department);
}
