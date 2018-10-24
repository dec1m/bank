package com.trach.bank.security;

import com.trach.bank.model.Client;
import org.springframework.security.core.GrantedAuthority;

public class ClientGrantedAuthority implements GrantedAuthority {
    private Client client;

    public ClientGrantedAuthority(Client client) {
        this.client=client;
    }

    @Override
    public String getAuthority() {
       return client.getRole();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
