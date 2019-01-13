package com.trach.bank.services.interfaces;


import com.trach.bank.model.Client;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ClientService {
     List<Client> findAll();
     Client findById(long id);
     void save(Client client);
     String findFirstNameById(long id);
     void update(Client client) ;
     void delete(Client client);
     void deleteById(long id);
     Client getByLogin(String login);
     Client getClientByIdAccount(long id);

}
