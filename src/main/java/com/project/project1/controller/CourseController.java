package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Professor;
import com.project.project1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class CourseController {

    @Autowired
     CourseService courseService;

    @RequestMapping("/courses/list")
    public ModelAndView professorsList(){
        ModelAndView modelAndView = new ModelAndView("courses");
        List<Course> courses = courseService.findAll();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }

    @GetMapping("/course/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("course", courseService.findById(Integer.parseInt(id)));
        return "courseInfo";}


    @RequestMapping("/course/delete/{id}")
    public String deleteById(@PathVariable String id){
        courseService.deleteById(Integer.parseInt(id));
        return "redirect:/courses/list";}


    @RequestMapping("/course/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        return "courseAdd";}

    @PostMapping("/course")
    public String saveOrUpdate(@ModelAttribute Course course)
    {   courseService.addCourse(course);
        return "redirect:/courses/list";
    }

}
