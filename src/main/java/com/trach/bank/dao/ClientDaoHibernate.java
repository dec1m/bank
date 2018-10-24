package com.trach.bank.dao;

import com.trach.bank.model.Client;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ClientDaoHibernate implements ClientDao  {
    private SessionFactory sessionFactory;

    @Override
    public List<Client> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createNamedQuery(Client.FIND_ALL,Client.class)
                .getResultList();

    }

    @Override
    public Client findById(long id) {
        return sessionFactory
                .getCurrentSession()
                .createNamedQuery(Client.GET_BY_ID,Client.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public void save(Client client) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(client);
    }

    @Override
    public String findFirstNameById(long id) {
        return sessionFactory
                .getCurrentSession()
                .createNamedQuery(Client.GET_LAST_NAME_BY_ID,String.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public void update(Client client) {
        sessionFactory
                .getCurrentSession()
                .update(client);

    }



    @Override
    public void delete(Client client) {
        sessionFactory
                .getCurrentSession()
                .delete(client);

    }

    @Override
    public void deleteById(long id) {
        sessionFactory
                .getCurrentSession()
                .createNamedQuery(Client.DELETE_BY_ID)
                .setParameter("id",id)
                .executeUpdate();

    }

    @Override
    public Client getByLogin(String login) {
       return sessionFactory
                .getCurrentSession()
                .createNamedQuery(Client.GET_BY_LOGIN,Client.class)
                .setParameter("login",login)
                .getSingleResult();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
