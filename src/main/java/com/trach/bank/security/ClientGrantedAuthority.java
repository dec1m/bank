package com.trach.bank.security;

import com.trach.bank.model.Authority;
import com.trach.bank.model.Client;
import org.springframework.security.core.GrantedAuthority;

public class ClientGrantedAuthority implements GrantedAuthority {
    private Authority authority;

    public ClientGrantedAuthority(Authority authority) {
        this.authority=authority;
    }

    @Override
    public String getAuthority() {
       return authority.getName();
    }

}
