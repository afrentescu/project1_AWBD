package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Dormitory;
import com.project.project1.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DormitoriesController {

    @Autowired
    private DormitoryService dormitoryService;


    @RequestMapping("/dormitories/list")
    public String dormitoriesList(Model model){
        List<Dormitory> dormitories = dormitoryService.findAll();
        model.addAttribute("dormitories",dormitories);return "dormitories";}
}
