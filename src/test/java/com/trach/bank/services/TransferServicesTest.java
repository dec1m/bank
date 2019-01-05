package com.trach.bank.services;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import com.trach.bank.services.interfaces.ClientService;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class TransferServicesTest {

    private ClientService service;
    private TransferServiceImpl transferService;
    private TransferDTO transferDTO;
    private int countMoneyToTransfer = 100;
    private int idSender = 1;
    private int idTarget = 2;

    @Before
    public void setUp(){

        service = mock(ClientService.class);
        transferService = new TransferServiceImpl();
        transferService.setClientService(service);
        transferDTO = new TransferDTO();



        transferDTO.setIdSender(idSender);
        transferDTO.setIdTarget(idTarget);
        transferDTO.setCountMoney(countMoneyToTransfer);


    }

    @Test
    public void transfer_logic_Test(){
        Client sender = new Client();
        sender.setId(idSender);
        Account accountSender = new Account();
        accountSender.setClient(sender);
        accountSender.setMoney(countMoneyToTransfer);
        sender.setAccount(accountSender);

        Client target = new Client();
        target.setId(idTarget);
        Account accountTarget = new Account();
        accountTarget.setClient(target);
        accountTarget.setMoney(0);
        target.setAccount(accountTarget);

        when(service.findById(idSender)).thenReturn(sender);
        when(service.findById(idTarget)).thenReturn(target);

        transferService.transfer(transferDTO);

        assertEquals(0,sender.getAccount().getMoney());
        assertEquals(100,target.getAccount().getMoney());


    }
    @Test(expected = IllegalArgumentException.class )
    public void transfer_Not_enough_money_in_the_account_Test(){
        Client sender = new Client();
        sender.setId(idSender);
        Account accountSender = new Account();
        accountSender.setClient(sender);
        accountSender.setMoney(1);
        sender.setAccount(accountSender);

        Client target = new Client();
        target.setId(idTarget);
        Account accountTarget = new Account();
        accountTarget.setClient(target);
        accountTarget.setMoney(0);
        target.setAccount(accountTarget);

        when(service.findById(idSender)).thenReturn(sender);
        when(service.findById(idTarget)).thenReturn(target);

        transferService.transfer(transferDTO);

      }

    @Test(expected = IllegalArgumentException.class )
    public void transfer_Not_found_client_Test(){
        transferService.transfer(transferDTO);
    }
    @Test(expected = IllegalArgumentException.class )
    public void transfer_yourself_Test(){
        Client sender = new Client();
        sender.setId(idSender);
        sender.setLogin("Еня");
        Account accountSender = new Account();
        accountSender.setClient(sender);
        accountSender.setMoney(countMoneyToTransfer + 1);
        sender.setAccount(accountSender);



        when(service.findById(idSender)).thenReturn(sender);
        when(service.findById(idTarget)).thenReturn(sender);

        transferService.transfer(transferDTO);

    }
}
