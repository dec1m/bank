package com.trach.bank.services;


import com.trach.bank.dto.TransferDTO;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import com.trach.bank.services.interfaces.TransferService;
import org.springframework.transaction.annotation.Transactional;


public class TransferServiceImpl implements TransferService {
    private Client clientSender;
    private long idSender;
    private long idTarget;
    private int countMoneyToTransfer;


    private ClientService clientService;

    @Override
    public void transfer(TransferDTO dto) {
        idSender = dto.getIdSender();
        idTarget = dto.getIdTarget();
        countMoneyToTransfer = dto.getCountMoney();
        Client clientTarget = clientService.findById(dto.getIdTarget());
        Client clientSender = clientService.findById(dto.getIdSender());
//TODO EXCEPTION, write new
        if(clientSender == null || clientTarget == null) {
            throw new IllegalArgumentException("clientSender == null OR clientTarget == null");
        }
        if(clientSender.getAccount().getMoney() < countMoneyToTransfer){
            throw new IllegalArgumentException("Not enough money in the account");
        }
        if(clientSender.equals(clientTarget)){
            throw new IllegalArgumentException("it is forbidden to transfer to yourself");
        }


        transfer(clientTarget,clientSender);



    }

    @Transactional
     void transfer(Client target,Client sender){
        sender.getAccount().setMoney(sender.getAccount().getMoney() - countMoneyToTransfer); //Withdrawal from the account
        clientService.update(sender);
        target.getAccount().setMoney(target.getAccount().getMoney() + countMoneyToTransfer); //Account replenishment
        clientService.update(target);
    }


    public long getCountMoney() {
        return countMoneyToTransfer;
    }

    public void setCountMoney(int countMoney) {
        this.countMoneyToTransfer = countMoney;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
