package com.trach.bank.dao;

import com.trach.bank.model.Client;

import java.util.List;

interface ClientDao {
    List<Client> findAll();
    Client findById(long id);
    void save(Client client);
    String findFirstNameById(long id);
    void update(Client client);
    void delete(Client client);
    void deleteById(long id);
}
