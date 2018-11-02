package com.trach.bank.services;

import com.trach.bank.dao.ClientDao;
import com.trach.bank.model.Client;
import com.trach.bank.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClientDetailsServiceImpl implements UserDetailsService {

   @Autowired
   private ClientDao clientDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientDao.findByLogin(login);
        return new UserDetailsImpl(client);
    }

}
