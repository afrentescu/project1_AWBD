package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Professor;
import com.project.project1.service.ProfessorSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorSevrice professorSevrice;
/*

    @RequestMapping("/professors/list")
    public String professorsList(Model model){
        List<Professor> professors = professorSevrice.findAll();
        model.addAttribute("professors",professors);
        return "professors";
     }*/
     @RequestMapping("/professors")
     public ModelAndView professorsList(){
    ModelAndView modelAndView = new ModelAndView("professors");
    List<Professor> professors = professorSevrice.findAll();
     modelAndView.addObject("professors",professors);
     return modelAndView;}
}
