package com.trach.bank.controllers;

//hg


import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
public class ClientControllerTest {

    private  ClientController controller;
    private Model model;

    @Before
    public void setUp(){
        controller = new ClientController();
        controller.setClientService(mock(ClientService.class));
        model = mock(Model.class);
    }




    @Test
    public void homePage_Test(){
       String expected = "/index";
       String actual =  controller.homePage();
       assertEquals(expected,actual);
    }

    @Test
    public void getAllClients_return_value_Test(){
        String expected = "/clients";
        String actual = controller.getAllClients(model);
        assertEquals(expected,actual);
    }

    @Test
    public void getAllClients_param_value_in_model_Test() {
        controller.getAllClients(model);
        verify(model).addAttribute(eq("clients"), isA(List.class));
    }

    @Test
    public void showClient_return_value_Test(){
        String expected = "/client";
        String actual = controller.showClient(1L,model);

        assertEquals(expected,actual);
    }

    @Test
    public void showClient_param_value_Test(){
     Client client = new Client();
     client.setId(1);
     when(controller.getClientService().findById(anyLong())).thenReturn(client);
        controller.showClient(1L,model);
     verify(model).addAttribute(eq("client"), isA(Client.class));


      }





    }



