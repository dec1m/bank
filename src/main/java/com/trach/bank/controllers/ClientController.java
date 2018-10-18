package com.trach.bank.controllers;

import com.trach.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class ClientController {

   private ClientService clientService;




    public ClientService getClientService() {
        return clientService;
    }
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){
        return "index";
    }

    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public String getAllUser(Model model){
         model.addAttribute("clients",clientService.findAll());
        return "clients";

    }

}
