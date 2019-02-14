package com.trach.bank.dao;

import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HibernateAccountDao implements  AccountDao {
 private SessionFactory sessionFactory;


    @Override
    public List<Account> findAllByClient(Client client) {
           return null;
    }

    @Override
    public Account findById(long id) {
        return  sessionFactory
                .getCurrentSession()
                .createNamedQuery(Account.GET_BY_ID,Account.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public void save(Account account) {
        sessionFactory
                .getCurrentSession()
                .save(account);

    }
    @Override
    public void update(Account account) {
        sessionFactory
                .getCurrentSession()
                .update(account);

    }


    @Override
    public void delete(Account account) {
        sessionFactory
                .getCurrentSession()

                .delete(account);
    }

    @Override
    public void deleteById(long id) {
        sessionFactory
                .getCurrentSession()
                .createNamedQuery(Account.DELETE_BY_ID)
                .setParameter("id",id);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
