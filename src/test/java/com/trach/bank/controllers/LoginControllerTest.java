package com.trach.bank.controllers;


import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

public class LoginControllerTest {

    private LoginController controller;
    @Before
    public void setUp(){
        controller = new LoginController();
    }

    @Test
    public void login_value_in_model_Test(){
        ModelAndView modelAndView = controller.login();
        assertEquals("/login",modelAndView.getViewName());

    }

    @Test
    public void login_return_value_Test(){
        ModelAndView expected = new ModelAndView();
        expected.setViewName("/login");
        ModelAndView actual = controller.login();
        assertEquals(actual.getViewName(),expected.getViewName());
        assertEquals(expected.getClass(),actual.getClass());


    }
    @Test
    public void access_return_value_Test(){
        String expected = "/accessDenied";
        String actual = controller.access();
        assertEquals(expected,actual);
    }

}
