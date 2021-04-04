package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Dormitory;
import com.project.project1.model.Professor;
import com.project.project1.model.Student;
import com.project.project1.service.DormitoryService;
import com.project.project1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentsController {
      @Autowired
      private StudentService studentService;
      @Autowired
      private DormitoryService dormitoryService;

    @RequestMapping("/students/list")
    public ModelAndView professorsList(){
        ModelAndView modelAndView = new ModelAndView("students");
        List<Student> students = studentService.findAll();
        modelAndView.addObject("students",students);
        return modelAndView;}

    @GetMapping("/student/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(Integer.parseInt(id)));
        return "studentInfo";}


    @RequestMapping("/student/delete/{id}")
    public String deleteById(@PathVariable String id){
        studentService.deleteById(Integer.parseInt(id));
        return "redirect:/students/list";}


    @RequestMapping("/student/new")
    public String newCourse(Model model) {
        List<Dormitory> dormitories = dormitoryService.findAll();
        model.addAttribute("student", new Student());
        model.addAttribute("dormitories", dormitories);
        return "studentAdd";}

    @PostMapping("/student")
    public String saveOrUpdate(@ModelAttribute Student student)
    {   studentService.addStudent(student);
        return "redirect:/students/list";
    }
}
