package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.services.interfaces.TransferService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;

import java.security.Principal;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

public class TransferControllerTest {

    private TransferController controller;
    private Model model;
    private TransferDTO transferDTO;
    private Principal principal;
    @Before
    public void setUp(){
        controller = new TransferController();
        TransferService transferService = mock(TransferService.class);
        controller.setTransfer(transferService);
        model = mock(Model.class);
        transferDTO = mock(TransferDTO.class);
        principal = mock(Principal.class);


    }

    @Test
    public void transferPage_return_value_Test(){
        String expected = "/transfer";
        String actual =  controller.transferPage(model);
        assertEquals(expected,actual);

    }

    @Test
    public void transferPage_addAttribute_to_model_Test(){
        controller.transferPage(model);
        verify(model).addAttribute(eq("transferDto"),isA(TransferDTO.class));


    }

    @Test
    @Ignore //todo CLASS CAST
    public void transfer_return_value_Test() throws TransferException {
        when(transferDTO.getIdSender()).thenReturn(1L);

        int idSender = 1;
        String expected = "redirect:/client/" +  idSender;
        String actual =  controller.transfer(principal,transferDTO);
        assertEquals(expected,actual);
    }

    @Test
    @Ignore  //todo CLASS CAST
    public void transfer_Test() throws TransferException {

     controller.transfer(principal,transferDTO);
        verify(controller.getTransfer()).transfer(isA(TransferDTO.class));
    }

}
