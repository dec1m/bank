package com.trach.bank.controllers;

//hg

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ClientControllerTest {

    private  ClientController controller;

    @Before
    public void setUp(){
        controller = new ClientController();
    }




    @Test
    public void homePage_Test(){
       String expected = "/index";
       String actual =  controller.homePage();
       assertEquals(expected,actual);
    }


}
