package com.trach.bank.security;

import com.trach.bank.model.Authority;
import com.trach.bank.model.Client;
import com.trach.bank.model.Group;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class UserDetailsImpl implements UserDetails  {
    private final Set<GrantedAuthority> authorities = new HashSet<>();
    private Client client;

    public UserDetailsImpl(Client client)   {
        this.client = client;
        try {
            initAuthorities();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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

    public void initAuthorities() throws IllegalAccessException {

        if( client == null){
            throw new IllegalAccessException("property client (type Client.class) must be installed. client == NULL ");
        }
        Group group;
        Authority authority;
        for (int countGroupInClient = 0; countGroupInClient < client.getGroups().size(); countGroupInClient++) {
            group = client.getGroups().get(countGroupInClient);

            for(int countAuthoritiesInGroup = 0; countAuthoritiesInGroup < group.getAuthorities().size(); countAuthoritiesInGroup++){
                authority = group.getAuthorities().get(countAuthoritiesInGroup);
                authorities.add(new GrantedAuthorityImpl(authority));
            }

        }
    }


}
