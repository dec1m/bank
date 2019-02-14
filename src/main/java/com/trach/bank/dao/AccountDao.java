package com.trach.bank.dao;

import com.trach.bank.model.Account;
import com.trach.bank.model.Client;

import java.util.List;

public interface AccountDao {
    List<Account> findAllByClient(Client client);
    Account findById(long id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
    void deleteById(long id);
}
