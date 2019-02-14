package com.trach.bank.controllers;

import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.AccountService;
import com.trach.bank.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class AccountController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "client/{id}/account/new", method = RequestMethod.GET)
    public String addNewAccountPage(Model model,@PathVariable long id){

        model.addAttribute("account",new Account());
        model.addAttribute("clientId",id);

        return "/newaccount";
    }

    @RequestMapping(value = "account/new/{id}",method = RequestMethod.POST)
    public String addNewAccount(@Valid @ModelAttribute Account account, @PathVariable long id){
        Client client = clientService.findById(id);
        account.setClient(client);
        client.getAccounts().add(account);
        accountService.save(account);


        return "redirect:/client/" + client.getId();
    }
    @RequestMapping(value = "client/account/delete/{id_client}/{id_acc}",method = RequestMethod.GET)
    public String delete(@PathVariable long id_acc, @PathVariable long id_client){
        Account account = accountService.findById(id_acc);
        accountService.delete(account);
        Client client = clientService.findById(id_client);
        client.getAccounts().remove(account);
        return "redirect:/client/" + client.getId();
    }



}
