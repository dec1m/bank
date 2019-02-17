package com.trach.bank.controllers;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PageController_Test {
    private PageController pageController;
    @Before
    public void setUp(){
        pageController = new PageController();


    }
    @Test
    public void homePage_return_value_Test(){
        String expected = "/index";
        String actual =  pageController.homePage();
        assertEquals(expected,actual);
    }
}
