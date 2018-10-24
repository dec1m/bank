package com.trach.bank.security;

import com.trach.bank.model.Client;
import com.trach.bank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClientDetailsServiceImpl implements UserDetailsService {
   @Autowired
   private ClientService clientService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);

        Client client = clientService.getByLogin(s);
        System.out.println();
        System.out.println(client);
        return new ClientPrincipal(client);
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
