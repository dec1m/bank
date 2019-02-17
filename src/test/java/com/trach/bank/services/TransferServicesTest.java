package com.trach.bank.services;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.model.Account;
import com.trach.bank.services.interfaces.AccountService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


public class TransferServicesTest {

    private AccountService accountService;
    private  Account sender;
    private Account target;
    private TransferServiceImpl transferService;
    private TransferDTO transferDTO;
    private int countMoneyToTransfer = 100;
    private int idSender = 1;
    private int idTarget = 2;

    @Before
    public void setUp(){

        accountService = mock(AccountService.class);

        transferService = new TransferServiceImpl();
        transferService.setAccountService(accountService);

        transferDTO = new TransferDTO();
        transferDTO.setIdTarget(idTarget);
        transferDTO.setIdSender(idSender);
        transferDTO.setCountMoney(countMoneyToTransfer);

        sender = new Account();
        sender.setId(idSender);

        target =  new Account();
        target.setId(idTarget);

        when(accountService.findById(idSender)).thenReturn(sender);
        when(accountService.findById(idTarget)).thenReturn(target);


    }

    @Test
    @Ignore
    public void transfer_logic_Test() throws TransferException {
        sender.setMoney(150);
        transferService.transfer(transferDTO);
        assertEquals(50,sender.getMoney());
        assertEquals(100,target.getMoney());


    }
    @Test(expected = TransferException.class )
    public void transfer_Not_enough_money_in_the_account_Test() throws TransferException {
        sender.setMoney(50);
        target.setMoney(0);
        transferService.transfer(transferDTO);

      }

    @Test(expected = TransferException.class )
    public void transfer_Not_found_client_Sender_Test() throws TransferException {

        when(accountService.findById(idSender)).thenReturn(null);


        transferService.transfer(transferDTO);
    }
    @Test(expected = TransferException.class )
    public void transfer_Not_found_client_Target_Test() throws TransferException {
        when(accountService.findById(idTarget)).thenReturn(null);
        transferService.transfer(transferDTO);
    }
    @Test(expected = TransferException.class )
    public void transfer_yourself_Test() throws TransferException {
        sender.setMoney(200);
        transferDTO.setIdSender(idSender);
        transferDTO.setIdTarget(idSender);

        transferService.transfer(transferDTO);


    }
}
