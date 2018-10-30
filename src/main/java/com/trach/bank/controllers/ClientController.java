package com.trach.bank.controllers;

import com.trach.bank.editors.LocalDateEditor;
import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.ClientService;
import com.trach.bank.services.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller

public class  ClientController {

   private ClientService clientService;




    public  ClientService getClientService() {
        return clientService;
    }
    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }


    private  TransferServiceImpl transferService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class,new LocalDateEditor());
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String test(){
        return "/index";
    }

    @RequestMapping(value = "/clients")
    public String getAllClients(Model model){
         model.addAttribute("clients",clientService.findAll());
        return "/clients";

    }
    @RequestMapping("/client/{id}")
    public String showClient( @PathVariable("id") long id, Model model){
        model.addAttribute("client",clientService.findById(id));
        return "/client";

    }
    @RequestMapping(value = "/accounts/{login}", method = RequestMethod.GET)
    public String showClientPage( @PathVariable("login") String login, Model model){
        Client client = clientService.getByLogin(login);
        model.addAttribute("client",client);
        model.addAttribute("accounts",client.getAccountList());
        return "/client";

    }

    @RequestMapping(value = "/accounts/del/{login}/{accountId}",method = RequestMethod.GET)
    public String deleteAccount(
            @PathVariable("accountId") long accountId, @PathVariable("login") String login){
        Client client = clientService.getByLogin(login);
        for (int i = 0; i < client.getAccountList().size(); i++) {
            if( client.getAccountList().get(i).getId() == accountId ){
                client.getAccountList().remove(client.getAccountList().get(i));
            }

        }
        clientService.update(client);
        return "redirect:/accounts/" + client.getLogin();
    }

    @RequestMapping(value = "/accounts/new/{id}",method = RequestMethod.GET)
    public String newAccount(@PathVariable("id") long id){
        Client client = clientService.findById(id);
        client.getAccountList().add(new Account(0,client));
        clientService.update(client);
        return "redirect:/accounts/" + client.getLogin();

    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerClientPage(Model model){
        model.addAttribute("client",new Client());
        return "/register";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute @Valid  Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }
        clientService.save(client);
        return "redirect:/clients";
    }
    @RequestMapping(value = "/accounts/transfer/{login}")
    public String transferPage(@PathVariable("login") String login,Model model){
        Client client = clientService.getByLogin(login);
        model.addAttribute("transfer",new TransferServiceImpl());
        model.addAttribute("client",client);

        return "/transfer";

    }
    @RequestMapping(value = "/transfer")
    public String transfer(@ModelAttribute TransferServiceImpl transfer){
        transfer.transfer();
        return "/transfer";

    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id){
        clientService.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("update/{id}")
    public String updateClient(@PathVariable("id") long id,Model model){
        Client client = clientService.findById(id);
        Map<String,String> role = new HashMap<>();
        role.put("User","ROLE_USER");
        role.put("Admin","ROLE_ADMIN");
        role.put("Anonymous","ROLE_ANONYMOUS");
        model.addAttribute("client",  client);
        model.addAttribute(role);
        return "/editClient";


    }
    @PostMapping("/update")
    public String updateClient(@Valid  @ModelAttribute Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update/"+ client.getId();
        }
          clientService.update(client);
        return "redirect:/client/" + client.getId();
    }



}
