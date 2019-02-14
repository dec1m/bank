package com.trach.bank.controllers;



import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindingResult;
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
    public void showClient_param_value_in_model_Test(){
     Client client = new Client();
     client.setId(1);
     when(controller.getClientService().findById(anyLong())).thenReturn(client);
        controller.showClient(1L,model);
     verify(model).addAttribute(eq("client"), isA(Client.class));


      }
    @Test
    public void showClientPage_return_value_Test(){
        Client clientMock = mock(Client.class);
        when(controller.getClientService().getByLogin(anyString())).thenReturn(clientMock);
        String expected = "/client";
        String actual = controller.showClientPage("nickname",model);
        assertEquals(expected,actual);
    }

    @Test
    public void showClientPage_param_value_in_model_Test(){
        Client clientMock = mock(Client.class);
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setMoney(100);
        account.setClient(clientMock);
        accounts.add(account);

        when(controller.getClientService().getByLogin(anyString())).thenReturn(clientMock);
        when(clientMock.getAccounts()).thenReturn(accounts);

        controller.showClientPage("nickname",model);

       verify(model).addAttribute(eq("client"), isA(Client.class));
       verify(model).addAttribute(eq("accounts"), isA(List.class));
       verifyNoMoreInteractions(model);

    }

    @Test
    public void registerClientPage_return_value_Test(){
        String expected = "/register";
        String actual = controller.registerClientPage(model);

        assertEquals(expected,actual);
    }



    @Test
    public void registerClientPage_param_value_in_model_Test(){

       controller.registerClientPage(model);
        verify(model).addAttribute(eq("client"), isA(Client.class));
        verifyNoMoreInteractions(model);

    }

    @Test
    public void registerClient_return_value_hasErrors_True_Test(){
        BindingResult bindingResult  = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);
        String expected = "/register";
        String actual = controller.registerClient(new Client(),bindingResult);
        assertEquals(expected,actual);


    }
    @Test
    public void registerClient_return_value_register_hasErrors_False_Test(){
        BindingResult bindingResult  = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        String expected = "redirect:/clients";
        String actual = controller.registerClient(new Client(),bindingResult);
        assertEquals(expected,actual);


    }

    @Test
    public void registerClient_save_Test(){
        BindingResult bindingResult  = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        controller.registerClient(new Client(),bindingResult);
        verify(controller.getClientService()).save(isA(Client.class));
        verifyNoMoreInteractions(controller.getClientService());

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
    public void updateClient_DownPage_param_value_in_model_Test(){
        when(controller.getClientService().findById(anyLong())).thenReturn(new Client());
        controller.updateClientPage(anyLong(),model);

        verify(model).addAttribute(eq("client"),isA(Client.class));
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

    @Test public void updateClient_Test(){
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        Client client = new Client();
        controller.updateClient(client,bindingResult);

        verify(controller.getClientService()).update(isA(Client.class));
        verifyNoMoreInteractions(controller.getClientService());
    }



    }



