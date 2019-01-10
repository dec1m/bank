package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class TransferController {

    public TransferService getTransfer() {
        return transfer;
    }

    @Autowired
    public void setTransfer(TransferService transfer) {
        this.transfer = transfer;
    }

    private TransferService transfer;

    @RequestMapping(value = "/transfer")
    public String transferPage( Model model) {
        model.addAttribute("transferDto",new TransferDTO() );
        return "/transfer";
    }

    @RequestMapping( value = "/transferTo")
    public String transfer(Principal principal, @ModelAttribute  TransferDTO transferDto) throws TransferException {

        Client activeClient = (Client) ((Authentication) principal).getPrincipal();




        transferDto.setIdSender(activeClient.getId());
        transfer.transfer(transferDto);
        return "redirect:/client/" + transferDto.getIdSender();
    }

}
