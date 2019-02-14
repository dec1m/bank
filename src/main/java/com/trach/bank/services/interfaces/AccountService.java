package com.trach.bank.services.interfaces;

import com.trach.bank.model.Account;

public interface AccountService {

    Account findById(long id);
    void update(Account account);
    void save(Account account);
    void delete(Account account);
    void deleteById(long id);

}
