package com.trach.bank.controllers;

import com.trach.bank.editors.LocalDateEditor;
import com.trach.bank.model.Client;
import com.trach.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller

public class  ClientController {

   private ClientService clientService;




    public ClientService getClientService() {
        return clientService;
    }
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class,new LocalDateEditor());
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){
        return "index";
    }

    @RequestMapping(value = "/clients")
    public String getAllClients(Model model){
         model.addAttribute("clients",clientService.findAll());
        return "clients";

    }
    @RequestMapping("/client/{id}")
    public String showClient( @PathVariable("id") long id, Model model){
        model.addAttribute("client",clientService.findById(id));
        return "client";

    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerClientPage(){
        return "register";
    }

    @PostMapping("/register")
    public String registerClient(Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }
        clientService.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id){
        clientService.deleteById(id);
        return "redirect:/clients";
    }
    @GetMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id,Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "editClient";


    }
    @PostMapping("/update")
    public String updateClient(Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update/"+ client.getId();
        }
        System.out.println(client);
        clientService.update(client);
        return "redirect:/client/" + client.getId();
    }


    @RequestMapping("/show/{id}")
    public String showJspx( @PathVariable("id") long id, Model model){
        model.addAttribute("client",clientService.findById(id));
        return "show";

    }

}
