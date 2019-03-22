package com.trach.bank.services;


import com.trach.bank.dto.TransferDTO;
import com.trach.bank.exceptions.transfer.TransferException;
import com.trach.bank.model.Account;
import com.trach.bank.services.interfaces.AccountService;
import com.trach.bank.services.interfaces.TransferService;
import com.trach.bank.services.interfaces.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class TransferServiceImpl implements TransferService {

    private long countMoneyToTransfer;
    @Autowired
    private CurrencyConverterService currencyConverterService;

    private AccountService accountService;

    @Override
    public void transfer(TransferDTO dto) throws TransferException {

        long idAccountSender = dto.getIdSender();
        long idAccountTarget = dto.getIdTarget();
        countMoneyToTransfer = dto.getCountMoney();
        Account accountTarget = accountService.findById(idAccountTarget);
        Account accountSender = accountService.findById(idAccountSender);


        if(accountSender == null || accountTarget == null) {
            throw new TransferException("clientSender == null OR clientTarget == null");
        }

        if(accountSender.getMoney() < countMoneyToTransfer){
            throw new TransferException("Not enough money in the account");
        }
        if(accountSender.equals(accountTarget)){
            throw new TransferException("it is forbidden to transfer to yourself");
        }


        transfer(accountTarget,accountSender);



    }

    @Transactional
     void transfer(Account target,Account sender){
        sender.setMoney(sender.getMoney() - countMoneyToTransfer); //Withdrawal from the account
        accountService.update(sender);
            long convertingMoney =  currencyConverterService.convert(sender.getCurrency()
                    ,target.getCurrency()
                    ,countMoneyToTransfer);
        target.setMoney(target.getMoney() + convertingMoney); //Account replenishment
        accountService.update(target);
    }


    public long getCountMoney() {
        return countMoneyToTransfer;
    }

    public void setCountMoney(int countMoney) {
        this.countMoneyToTransfer = countMoney;
    }


    public CurrencyConverterService getCurrencyConverterService() {
        return currencyConverterService;
    }

    public void setCurrencyConverterService(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}
