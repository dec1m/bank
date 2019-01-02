package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.services.interfaces.TransferService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

public class TransferControllerTest {

    private TransferController controller;
    private Model model;
    private TransferDTO transferDTO;

    @Before
    public void setUp(){
        controller = new TransferController();
        TransferService transferService = mock(TransferService.class);
        controller.setTransfer(transferService);
        model = mock(Model.class);
        transferDTO = mock(TransferDTO.class);


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
    public void transfer_return_value_Test(){
        when(transferDTO.getIdSender()).thenReturn(1L);
        int idSender = 1;
        String expected = "redirect:/client/" +  idSender;
        String actual =  controller.transfer(transferDTO);
        assertEquals(expected,actual);
    }

    @Test
    public void transfer_Test(){

     controller.transfer(transferDTO);
        verify(controller.getTransfer()).transfer(isA(TransferDTO.class));
    }

}
