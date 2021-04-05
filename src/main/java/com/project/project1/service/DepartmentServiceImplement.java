package com.project.project1.service;

import com.project.project1.exceptions.ObjectNotFoundException;
import com.project.project1.model.Department;
import com.project.project1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImplement implements DepartmentService{

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImplement(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Department> findAll() {
        List<Department> departments = new LinkedList<>();
        departmentRepository.findAll().iterator().forEachRemaining(departments::add);
        return departments;
    }

    @Override
    public Department findById(int id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (!departmentOptional.isPresent())
        {
            throw new ObjectNotFoundException("The deparment you are looking for doesn't exist!");
        }
        return departmentOptional.get();
    }

    @Override
    public Department addDepartment(Department department) {
        Department savedDepartment = departmentRepository.save(department);
        return savedDepartment;    }
}
