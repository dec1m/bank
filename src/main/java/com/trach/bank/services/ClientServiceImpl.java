package com.trach.bank.services;

import com.trach.bank.dao.ClientDao;
import com.trach.bank.model.Client;
import java.util.List;


public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientDao getClientDao() {
        return clientDao;
    }


     public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    public List<Client> findAll() {
        return clientDao.findAll();
    }


    public Client findById(long id) {
        return clientDao.findById(id);
    }


    public void save(Client client) {
        clientDao.save(client);
    }


    public String findFirstNameById(long id) {
        return clientDao.findFirstNameById(id);
    }


    public void update(Client client) {
        clientDao.update(client);
    }


    public void delete(Client client) {
        clientDao.delete(client);
    }


    public void deleteById(long id) {
        clientDao.deleteById(id);
    }

    public Client getByLogin(String login){
       return clientDao.getByLogin(login);
    }

    public Client getClientByIdAccount(long id){
       return clientDao.getClientByAccountID(id);

    }

    public void transfer(Client client,long idAccountSender, long idAccountTarget,long countMoney){

    }

}