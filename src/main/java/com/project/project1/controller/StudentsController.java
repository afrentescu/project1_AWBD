package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentsController {
      @Autowired
      private StudentService studentService;

    @RequestMapping("/students")
    public ModelAndView professorsList(){
        ModelAndView modelAndView = new ModelAndView("students");
        List<Student> students = studentService.findAll();
        modelAndView.addObject("students",students);
        return modelAndView;}
}
