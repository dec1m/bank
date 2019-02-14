package com.trach.bank.services;

import com.trach.bank.dao.AccountDao;
import com.trach.bank.model.Account;
import com.trach.bank.services.interfaces.AccountService;


import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao dao;

    @Override
    public Account findById(long id) {
        return  dao.findById(id);
    }

    @Override
    public void save(Account account) {
        dao.save(account);
    }

  @Override
    public void update(Account account) {
        dao.update(account);
    }


    @Override
    public void delete(Account account) {
        dao.delete(account);
    }

    @Override
    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public AccountDao getDao() {
        return dao;
    }

    public void setDao(AccountDao dao) {
        this.dao = dao;
    }
}
