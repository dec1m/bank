package com.trach.bank.services;

import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.model.Account;
import com.trach.bank.model.Currency;
import com.trach.bank.services.interfaces.AccountService;
import com.trach.bank.dao.coursProvider.CurrencyCourseProviderTest;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;


public class TransferServicesTest {

    private AccountService accountService;
    private  Account sender;
    private Account target;
    private TransferServiceImpl transferService;
    private TransferDTO transferDTO;
    private long countMoneyToTransfer = 131;
    private long idSender = 1;
    private long idTarget = 2;
   private long countSenderMoney = 1000_00;
   private long countTargetMoney = 0;

    @Before
    public void setUp(){

        accountService = mock(AccountService.class);

        transferService = new TransferServiceImpl();
        transferService.setAccountService(accountService);
        transferService.setCurrencyConverterService(new CurrencyConverterServiceImpl(new CurrencyCourseProviderTest()));

        transferDTO = new TransferDTO();
        transferDTO.setIdTarget(idTarget);
        transferDTO.setIdSender(idSender);
        transferDTO.setCountMoney(countMoneyToTransfer);

        sender = new Account();
        sender.setId(idSender);
        sender.setMoney(countSenderMoney);

        target =  new Account();
        target.setId(idTarget);
        target.setMoney(countTargetMoney);



        when(accountService.findById(idSender)).thenReturn(sender);
        when(accountService.findById(idTarget)).thenReturn(target);


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
    @Test
    public void transfer_test() throws TransferException {
        sender.setMoney(countSenderMoney);
        sender.setCurrency(Currency.USD);
        target.setCurrency(Currency.USD);
        target.setMoney(countTargetMoney);

        long expectedSender = countSenderMoney - countMoneyToTransfer * 100;
        long expectedTarget = countTargetMoney + countMoneyToTransfer * 100;
        transferService.transfer(transferDTO);
        assertEquals(expectedSender,sender.getMoney());
        assertEquals(expectedTarget,target.getMoney());

    }
}
