package com.trach.bank.controllers;

import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.AccountService;
import com.trach.bank.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@SessionAttributes("idClient")
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/new/{idClient}", method = RequestMethod.GET)
    public String addNewAccountPage(Model model, @PathVariable  long idClient,
                                    HttpSession httpSession){

        httpSession.setAttribute("idClient",idClient);
        model.addAttribute("account",new Account());
        model.addAttribute("clientId",idClient);

        return "/newaccount";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String addNewAccount(@Valid @ModelAttribute Account account, @SessionAttribute long idClient){
        Client client = clientService.findById(idClient);
        account.setClient(client);
        client.getAccounts().add(account);
        accountService.save(account);


        return "redirect:/client/" + client.getId();
    }
    @RequestMapping(value = "/delete/{id_acc}",method = RequestMethod.GET)
    public String delete(@PathVariable long id_acc,@SessionAttribute long idClient){
        Account account = accountService.findById(id_acc);
        accountService.delete(account);
        Client client = clientService.findById(idClient);
        client.getAccounts().remove(account);
        return "redirect:/client/" + client.getId();
    }



}
