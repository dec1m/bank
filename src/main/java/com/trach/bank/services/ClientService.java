package com.trach.bank.services;


import com.trach.bank.model.Client;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ClientService {
    @Secured("ROLE_ADMIN")
     List<Client> findAll();
    @Secured("{ROLE_ADMIN,ROLE_USER}")
     Client findById(long id);
 @Secured("{ROLE_ADMIN,ROLE_USER}")
     void save(Client client);
 @Secured("{ROLE_ADMIN,ROLE_USER}")
     String findFirstNameById(long id);
 @Secured("ROLE_ADMIN")
     void update(Client client) ;
 @Secured("ROLE_ADMIN")
     void delete(Client client);
 @Secured("ROLE_ADMIN")
     void deleteById(long id);

     Client getByLogin(String login);

     Client getClientByIdAccount(long id);

}
