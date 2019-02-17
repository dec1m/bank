package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class TransferController {


    private TransferService transfer;

    @RequestMapping(value = "/transfer/{idAccountSender}")
    public String transferPage(Model model, @PathVariable long idAccountSender) {
        model.addAttribute("transferDto",new TransferDTO() );
        model.addAttribute("idAccountSender", idAccountSender);
        return "/transfer";
    }

    @RequestMapping( value = "/transferTo/{idAccountSender}")
    public String transfer(Principal principal, @ModelAttribute TransferDTO transferDto, @PathVariable long idAccountSender) throws TransferException {

        Client activeClient = (Client) ((Authentication) principal).getPrincipal();
        transferDto.setIdSender(idAccountSender);

        for (Account account : activeClient.getAccounts()) {
            if(account.getId() == idAccountSender){
                transfer.transfer(transferDto);
            }
        }

        return "redirect:/client/" + activeClient.getId();
    }
    public TransferService getTransfer() {
        return transfer;
    }

    @Autowired
    public void setTransfer(TransferService transfer) {
        this.transfer = transfer;
    }

}
