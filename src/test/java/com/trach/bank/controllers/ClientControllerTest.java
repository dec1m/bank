package com.trach.bank.controllers;

import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ClientControllerTest {

    private  ClientController controller;
    private Model model;

    @Before
    public void setUp(){
        controller = new ClientController();
        controller.setClientService(mock(ClientService.class));
        model = mock(Model.class);
        Client client = new Client();
        client.setId(1);
        when(controller.getClientService().findById(anyLong())).thenReturn(client);

    }





    @Test
    public void showClient_return_value_Test(){

        String expected = "/client";
        String actual = controller.showClient(1L,model);

        assertEquals(expected,actual);
    }

    @Test
    public void showClient_param_value_in_model_Test(){
      controller.showClient(1L,model);
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

    @Test public void updateClient_return_value_hasErrors_False_Test(){
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        Client client = new Client();
        client.setId(1);
        String expected =  "redirect:/client/" + client.getId();
        String actual = controller.updateClient(client,bindingResult);
        assertEquals(expected,actual);
    }
    @Test public void updateClient_return_value_hasErrors_True_Test(){
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);
        Client client = new Client();
        String expected =  "/update/" + client.getId();
        String actual = controller.updateClient(client,bindingResult);
        assertEquals(expected,actual);
    }

    @Test public void updateClient_logic_Test(){
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        Client client = new Client();
        controller.updateClient(client,bindingResult);

        verify(controller.getClientService()).update(isA(Client.class));
        verifyNoMoreInteractions(controller.getClientService());
    }
    @Test
    @Ignore
    public void getAllClients_return_value_Test(){
        //todo realise method
    }

    @Test
    @Ignore
    public void getAllClients_logic_Test_(){
        //todo realise method
    }
    @Test
    @Ignore
    public void registerClientPage_logic_Test_(){
        //todo realise method
    }
    @Test
    @Ignore
    public void registerClient_logic_Test_(){
        //todo realise method
    }
    @Test
    @Ignore
    public void registerClient_return_value_Test_(){
        //todo realise method
    }


    }



