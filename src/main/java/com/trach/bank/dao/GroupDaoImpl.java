package com.trach.bank.dao;

import com.trach.bank.model.Group;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GroupDaoImpl implements GroupDao {
    private SessionFactory sessionFactory;
    @Override
    public Group findGroupByName(String name) {
        return  sessionFactory
                .getCurrentSession()
                .createNamedQuery(Group.FIND_GROUP_BY_NAME,Group.class)
                .setParameter("name",name)
                .getSingleResult();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
