package com.trach.bank.security;

import com.trach.bank.model.Client;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



public class ClientPrincipal implements UserDetails {
    private final Set<GrantedAuthority> authorities = new HashSet<>();
    private Client client;

    public ClientPrincipal(Client client){
        this.client = client;
        ClientGrantedAuthority clientGrantedAuthority = new ClientGrantedAuthority(client);
        authorities.add(clientGrantedAuthority);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
       return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
