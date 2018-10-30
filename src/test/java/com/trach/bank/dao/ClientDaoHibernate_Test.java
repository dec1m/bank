package com.trach.bank.dao;


import com.trach.bank.model.Account;
import com.trach.bank.model.Client;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ClientDaoHibernate_Test {

    private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    private ClientDao dao;


    @BeforeClass
    public static void setUpClass(){
        context.load("root-config.xml");
        context.load("db/test/hibernate-datasource-test.xml");
        context.refresh();
    }
    @Before
    public void setUp(){

        dao = (ClientDao) context.getBean("clientDaoHibernate");



    }


    @Test
    public void findById_Test(){
        Client client = new Client();
        client.setId(1);
        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("Eugen");
        client.setLastName("Trach");
        client.setPassword("123123");
        client.setRole("ROLE_USER");
        client.setLogin("decim");
        client.setPhone_number(67389042);
       assertEquals(client,dao.findById(1));
    }

    @Test
    public void findById_Bad_Param_Test(){

        Client clientBad = new Client();
        clientBad.setId(999);
        clientBad.setBirthDay(LocalDate.of(1111,1,11));
        clientBad.setFirstName("BAD_PARAM");
        clientBad.setLastName("BAD_PARAM");
        clientBad.setPassword("BAD_PARAM");
        clientBad.setRole("BAD_PARAM");
        clientBad.setLogin("BAD_PARAM");
        clientBad.setPhone_number(1111);
        assertNotEquals(clientBad,dao.findById(1));
    }

    @Test
    public void getByLogin_Test(){
        Client client = new Client();
        client.setId(1);
        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("Eugen");
        client.setLastName("Trach");
        client.setPassword("123123");
        client.setRole("ROLE_USER");
        client.setLogin("decim");
        client.setPhone_number(67389042);

        Client actual = dao.getByLogin("decim");
        assertEquals(client,actual);
    }

    //Dependent  dao.getByLogin();
    @Test
    public void persist_Test(){
       Client persistClient = new Client();
        persistClient.setBirthDay(LocalDate.of(1994,7,13));
        persistClient.setFirstName("persist_Test");
        persistClient.setLastName("persist_Test");
        persistClient.setPassword("persist_Test");
        persistClient.setRole("persist_Test");
        persistClient.setLogin("persist_Test");
        persistClient.setPhone_number(67389042);

        dao.save(persistClient);

      Client actual = dao.getByLogin("persist_Test");

       assertEquals(persistClient,actual);



    }


    @Test(expected = NoResultException.class)
    public void delete_Test(){
        Client deleteClient = new Client();
        deleteClient.setBirthDay(LocalDate.of(1994,7,13));
        deleteClient.setFirstName("deleteClient");
        deleteClient.setLastName("deleteClient");
        deleteClient.setPassword("deleteClient");
        deleteClient.setRole("deleteClient");
        deleteClient.setLogin("deleteClient");
        deleteClient.setPhone_number(67389042);
        dao.save(deleteClient);
        dao.delete(deleteClient);
        dao.getByLogin("deleteClient");


    }

    @Test
    public void update_Test(){
        Client client = new Client();
        client.setId(1);
        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("EugenUpdate");
        client.setLastName("Trach");
        client.setPassword("123123");
        client.setRole("ROLE_USER");
        client.setLogin("decim");
        client.setPhone_number(67389042);

        dao.update(client);
        Client actual = dao.findById(1);

        assertEquals(client,actual);
    }

    @Test
    public void getClientByAccountID_Test(){
        Client client = new Client();

        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("getClientByAccountID_Test");
        client.setLastName("getClientByAccountID_Test");
        client.setPassword("getClientByAccountID_Test");
        client.setRole("ROLE_USER");
        client.setLogin("getClientByAccountID_Test");
        client.setPhone_number(67389042);
        Account account = new Account(1,client);
        List<Account> accountList =  new ArrayList<Account>();
        accountList.add(account);
        client.setAccountList(accountList);

        dao.save(client);
        System.out.println(dao.getByLogin("getClientByAccountID_Test").getAccountList().get(0));
        System.out.println(account);
        Client clientByAccountID = dao.getClientByAccountID(1);


        assertEquals(clientByAccountID.getAccountList().get(0),account);
     }


}


