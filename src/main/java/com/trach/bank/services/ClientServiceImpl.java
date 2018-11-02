package com.trach.bank.services;

import com.trach.bank.dao.ClientDao;
import com.trach.bank.model.Client;
import com.trach.bank.model.Group;
import com.trach.bank.services.interfaces.ClientService;
import com.trach.bank.services.interfaces.GroupService;

import java.util.List;


public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    private GroupService groupService;

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

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
        Group group = groupService.findGroupByName("User");
        client.setGroup(group);
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
       return clientDao.findByLogin(login);
    }

    public Client getClientByIdAccount(long id){
       return clientDao.findClientByAccountID(id);

    }


    public void transfer(Client client,long idAccountSender, long idAccountTarget,long countMoney){

    }

}