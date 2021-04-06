package com.project.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/showLogInForm")
    public String showLogInForm(){
        return "login";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";}

        @RequestMapping({"", "/", "/home"})
        public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("homepage");
        modelAndView.addObject("homepage");
        return modelAndView;
    }
}
