package com.project.project1.controller;

import com.project.project1.model.Course;
import com.project.project1.model.Professor;
import com.project.project1.service.ProfessorSevrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
     @RequestMapping("/professors/list")
     public ModelAndView professorsList(){
    ModelAndView modelAndView = new ModelAndView("professors");
    List<Professor> professors = professorSevrice.findAll();
     modelAndView.addObject("professors",professors);
     return modelAndView;}

    @GetMapping("/professor/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("professor", professorSevrice.findById(Integer.parseInt(id)));
        return "profInfo";}


    @RequestMapping("/professor/delete/{id}")
    public String deleteById(@PathVariable String id){
        professorSevrice.deleteById(Integer.parseInt(id));
        return "redirect:/professors/list";}


    @RequestMapping("/professor/new")
    public String newProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "profAdd";}

    @PostMapping("/professor")
    public String saveOrUpdate(@ModelAttribute Professor professor)
    {   professorSevrice.addProfessor(professor);
        return "redirect:/professors/list";
    }
}
