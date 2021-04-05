package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Department;
import com.project.project1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
     DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService =departmentService;
    }


    @RequestMapping("/departments/list")
    public ModelAndView professorsList(){
        ModelAndView modelAndView = new ModelAndView("departments");
        List<Department> departments = departmentService.findAll();
        modelAndView.addObject("departments",departments);
        return modelAndView;
    }

    @GetMapping("/department/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("department", departmentService.findById(Integer.parseInt(id)));
        return "departmentInfo";}

    @RequestMapping("/department/new")
    public String newCourse(Model model) {
        model.addAttribute("department", new Department());
        return "departmentAdd";}

    @PostMapping("/department")
    public String saveOrUpdate(@Valid @ModelAttribute Department department)
    {   departmentService.addDepartment(department);
        return "redirect:/departments/list";
    }

}
