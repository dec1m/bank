package com.trach.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Transactional
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView model  = new ModelAndView();
        model.setViewName("/login");
        return model ;
    }
    @RequestMapping("/access")
    public String access(){
        return "/accessDenied";
    }


}