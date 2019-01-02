package com.trach.bank.controllers;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.services.interfaces.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/account/transfer")
    public String transferPage(Model model) {
        TransferDTO transferDto = new TransferDTO();
        model.addAttribute("transferDto",transferDto );
        return "/transfer";
    }

    @RequestMapping(value = "/transfer")
    public String transfer(@ModelAttribute TransferDTO transferDto) {
        transfer.transfer(transferDto);
        return "redirect:/client/" + transferDto.getIdSender();
    }
}
