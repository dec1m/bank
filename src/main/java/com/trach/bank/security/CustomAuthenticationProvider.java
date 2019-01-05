package com.trach.bank.security;

import com.trach.bank.model.Authority;
import com.trach.bank.model.Client;
import com.trach.bank.model.Group;
import com.trach.bank.services.interfaces.ClientService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    private  ClientService clientService;
    private BCryptPasswordEncoder encoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Client client = clientService.getByLogin(authentication.getName());
        String password = authentication.getCredentials().toString();
        String encodedPassword = client.getPassword();
        if(!(encoder.matches(password,encodedPassword))){
            throw new BadCredentialsException("Credentials invalid ");

        }
        return new UsernamePasswordAuthenticationToken(client,client.getPassword(),getAuthorities(client));
    }

    @Override
    public boolean supports(Class<?> authentication) {
      return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

  protected static Set<GrantedAuthority> getAuthorities(Client client){
       Set<GrantedAuthority> authorities = new HashSet<>();
       Group group = client.getGroup();
       Authority authority;

        for(int countAuthoritiesInGroup = 0; countAuthoritiesInGroup < group.getAuthorities().size(); countAuthoritiesInGroup++){
                authority = group.getAuthorities().get(countAuthoritiesInGroup);
                authorities.add(new GrantedAuthorityImpl(authority));
            }
        return authorities;
        }

    public  ClientService getClientService() {
        return clientService;
    }

    public  void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }
}
