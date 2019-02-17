package com.trach.bank.controllers;

import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ClientControllerTest {

    private  ClientController controller;
    private Model model;
    private BindingResult bindingResult;
    private  Client client;
    private HttpSession httpSession;
    @Before
    public void setUp(){
        controller = new ClientController();
        controller.setClientService(mock(ClientService.class));
        model = mock(Model.class);
        httpSession = mock( HttpSession.class);
        bindingResult = mock(BindingResult.class);
       client = new Client();
        client.setId(1);
        when(controller.getClientService().findById(anyLong())).thenReturn(client);
        when(controller.getClientService().findAll()).thenReturn(new ArrayList<>());
    }





    @Test
    public void showClient_return_value_Test(){

        String expected = "/client";
        String actual = controller.showClient(1L,model,httpSession);

        assertEquals(expected,actual);
    }

    @Test
    public void showClient_param_value_in_model_Test(){
      controller.showClient(1L,model,httpSession);
     verify(model).addAttribute(eq("client"), isA(Client.class));
        //todo isA expected any List, but need List<Account>
        verify(model).addAttribute(eq("accounts"),isA(List.class));
        verifyNoMoreInteractions(model);
  }


    @Test
    public  void deleteClient_return_value_Test(){
        String expected = "redirect:/clients";
        String actual = controller.deleteClient(anyLong());
        assertEquals(expected,actual);

    }

    @Test
    public  void deleteClient_Test(){

        controller.deleteClient(anyLong());

        verify(controller.getClientService()).deleteById(anyLong());
        verifyNoMoreInteractions(controller.getClientService());

    }


    @Test
    public void updateClient_DownPage_return_value_Test(){
        String expected =  "/editClient";
        String actual = controller.updateClientPage(anyLong(),model);

        assertEquals(expected,actual);
    }
    @Test
    public void updateClientPage_param_value_in_model_Test(){

        controller.updateClientPage(anyLong(),model);

        verify(model).addAttribute(eq("client"),isA(Client.class));
        verify(model).addAttribute(eq("roles"),isA(Map.class));
        verifyNoMoreInteractions(model);
    }

    @Test public void updateClient_return_value_hasErrors_FALSE_Test(){

        when(bindingResult.hasErrors()).thenReturn(false);
        Client client = new Client();
        client.setId(1);
        String expected =  "redirect:/client/" + client.getId();
        String actual = controller.updateClient(client,bindingResult);
        assertEquals(expected,actual);
    }
    @Test public void updateClient_return_value_hasErrors_TRUE_Test(){

        when(bindingResult.hasErrors()).thenReturn(true);
        Client client = new Client();
        String expected =  "/update/" + client.getId();
        String actual = controller.updateClient(client,bindingResult);
        assertEquals(expected,actual);
    }

    @Test public void updateClient_logic_Test(){

        when(bindingResult.hasErrors()).thenReturn(false);
        Client client = new Client();
        controller.updateClient(client,bindingResult);

        verify(controller.getClientService()).update(isA(Client.class));
        verifyNoMoreInteractions(controller.getClientService());
    }
    @Test
    public void getAllClients_return_value_Test(){
        String expected =  "/clients";
        String actual = controller.getAllClients(model);

        assertEquals(expected,actual);
    }

    @Test
    public void getAllClients_logic_Test_(){


        controller.getAllClients(model);
        verify(model).addAttribute(eq("clients"),isA(List.class));
        verify(controller.getClientService()).findAll();
        verifyNoMoreInteractions(model);
        verifyNoMoreInteractions(controller.getClientService());
    }
    @Test
    public void registerClientPage_return_value_Test_(){
        String expected =  "/register";
        String actual = controller.registerClientPage(model);
        assertEquals(expected,actual);
    }

    @Test
    public void registerClient_return_value_hasErrors_FALSE_Test_(){
        when(bindingResult.hasErrors()).thenReturn(false);
        String expected =  "redirect:/clients";
        String actual = controller.registerClient(client,bindingResult);
        assertEquals(expected,actual);
    }
    @Test
    public void registerClient_return_value_hasErrors_TRUE_Test_(){
        when(bindingResult.hasErrors()).thenReturn(true);
        String expected =  "/register";
        String actual = controller.registerClient(client,bindingResult);
        assertEquals(expected,actual);
    }
    @Test
    public void registerClient_logic_Test_(){

        controller.registerClient(client,bindingResult);
        verify(controller.getClientService()).save(isA(Client.class));
        verifyNoMoreInteractions(controller.getClientService());
    }

    }



