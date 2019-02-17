package com.trach.bank.controllers;


import com.trach.bank.editors.LocalDateEditor;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ClientController {

    private ClientService clientService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }





    @RequestMapping("client/{id}")
    public String showClient(@PathVariable("id") long idClient, Model model,  HttpSession httpSession) {
        httpSession.setAttribute("idClient",idClient);
        Client client = clientService.findById(idClient);
        model.addAttribute("client", client);
        model.addAttribute("accounts",client.getAccounts());

        return "/client";

    }


    @GetMapping("client/delete/{id}")
    public String deleteClient(@PathVariable("id") long id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("client/update/{id}")
    public String updateClientPage(@PathVariable("id") long id, Model model) {
        Client client = clientService.findById(id);
        Map<String, String> role = new HashMap<>();
        role.put("User", "ROLE_USER");
        role.put("Admin", "ROLE_ADMIN");
        role.put("Anonymous", "ROLE_ANONYMOUS");
        model.addAttribute("client", client);
        model.addAttribute("roles",role);
        return "/editClient";


    }

    @PostMapping("client/update")
    public String updateClient(@Valid @ModelAttribute Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/update/" + client.getId();
        }
        clientService.update(client);
        return "redirect:/client/" + client.getId();
    }

    @RequestMapping(value = "clients")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "/clients";

    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerClientPage(Model model) {
        model.addAttribute("client", new Client());
        return "/register";
    }

    @PostMapping("/register")
    public String registerClient(@ModelAttribute @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }


        clientService.save(client);


        return "redirect:/clients";
    }



    public ClientService getClientService() {
        return clientService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;

    }

}
