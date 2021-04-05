package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Department;
import com.project.project1.model.Dormitory;
import com.project.project1.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DormitoriesController {

    @Autowired
     DormitoryService dormitoryService;

    public DormitoriesController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }


    @RequestMapping("/dormitories/list")
    public ModelAndView professorsList(){
        ModelAndView modelAndView = new ModelAndView("dormitories");
        List<Dormitory> dormitories = dormitoryService.findAll();
        modelAndView.addObject("dormitories",dormitories);
        return modelAndView;
    }

    @GetMapping("/dormitory/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("dormitory", dormitoryService.findById(Integer.parseInt(id)));
        return "dormitoryInfo";}

    @RequestMapping("/dormitory/new")
    public String newCourse(Model model) {
        model.addAttribute("dormitory", new Dormitory());
        return "dormitoryAdd";}

    @PostMapping("/dormitory")
    public String saveOrUpdate(@Valid @ModelAttribute Dormitory dormitory)
    {   dormitoryService.addDormitory(dormitory);
        return "redirect:/dormitories/list";
    }

}
