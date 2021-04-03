package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Department;
import com.project.project1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/departments/list")
    public String departmentsList(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments",departments);return "departments";}

}
