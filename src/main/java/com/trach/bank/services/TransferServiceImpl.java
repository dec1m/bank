package com.trach.bank.services;

import com.trach.bank.dao.ClientDao;
import com.trach.bank.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

public class TransferServiceImpl implements TransferService {

    private long idAccountSender;
    private long idAccountTarget;
    private int countMoney;

    @Autowired
    private ClientDao clientDao;

    @Override
    public void transfer() {
        if(idAccountTarget == 0 || idAccountTarget == 0 || countMoney == 0 ){
            throw new IllegalArgumentException("NO INIT PROPERTIES");
        }
        Client clientSender = clientDao.getClientByAccountID(idAccountSender);
        Client clientTarget = clientDao.getClientByAccountID(idAccountTarget);

        for (int i = 0; i < clientSender.getAccountList().size() ; i++) {
                if(clientSender.getAccountList().get(i).getId() == idAccountSender && clientSender.getAccountList().get(i).getMoney() > countMoney ){
                    clientSender.getAccountList().get(i).setMoney(clientSender.getAccountList().get(i).getMoney() - countMoney);
                    for (int j = 0; j < idAccountTarget; j++) {
                        if(clientTarget.getAccountList().get(j).getId() ==  idAccountTarget){
                            int moneyInTarget = clientTarget.getAccountList().get(j).getMoney();
                            clientTarget.getAccountList().get(j).setMoney( moneyInTarget + countMoney);
                        }
                    }
                }

        }

    }



    public long getIdAccountSender() {
        return idAccountSender;
    }

    public void setIdAccountSender(long idAccountSender) {
        this.idAccountSender = idAccountSender;
    }

    public long getIdAccountTarget() {
        return idAccountTarget;
    }

    public void setIdAccountTarget(long idAccountTarget) {
        this.idAccountTarget = idAccountTarget;
    }

    public long getCountMoney() {
        return countMoney;
    }

    public void setCountMoney(int countMoney) {
        this.countMoney = countMoney;
    }
}
