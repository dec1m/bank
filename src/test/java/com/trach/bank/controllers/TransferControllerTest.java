package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.services.interfaces.TransferService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;
import static junit.framework.TestCase.assertEquals;

public class TransferControllerTest {

    private TransferController controller;
    private Model model;

    @Before
    public void setUp(){
        controller = new TransferController();
        TransferService transferService = mock(TransferService.class);
        controller.setTransfer(transferService);
        model = mock(Model.class);


    }

    @Test
    public void transferPage_return_value_Test(){
        String expected = "/transfer";
        String actual =  controller.transferPage(model,0);
        assertEquals(expected,actual);

    }

    @Test
    public void transferPage_addAttribute_to_model_Test(){
        controller.transferPage(model,0);
        verify(model).addAttribute(eq("transferDto"),isA(TransferDTO.class));


    }
    @Test
    @Ignore
    public void transfer_logic_Test(){
        //todo realise method
    }


}
