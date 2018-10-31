package com.trach.bank.security;

import com.trach.bank.model.Authority;
import com.trach.bank.model.Client;
import com.trach.bank.model.Group;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class ClientPrincipal implements UserDetails {
    private final Set<GrantedAuthority> authorities = new HashSet<>();
    private Client client;

    public ClientPrincipal(Client client){
        this.client = client;
        Group group;
        Authority authority;
        ClientGrantedAuthority clientGrantedAuthority;
        for (int countGroupInClient = 0; countGroupInClient < client.getGroups().size(); countGroupInClient++) {
            group = client.getGroups().get(countGroupInClient);

            for(int countAuthoritiesInGroup = 0; countAuthoritiesInGroup < group.getAuthorities().size(); countAuthoritiesInGroup++){
                      authority = group.getAuthorities().get(countAuthoritiesInGroup);
                      authorities.add(new ClientGrantedAuthority(authority));
            }

        }
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        Iterator<GrantedAuthority> iterator = authorities.iterator();
        while (iterator.hasNext()){

            GrantedAuthority next = iterator.next();
            System.out.println(next.getAuthority());
        }
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");

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
