//package com.trach.bank.dao;
//
//import com.trach.bank.model.Client;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//import javax.persistence.NoResultException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNull;
//
//public class ClientDaoHibernate_Test {
//
//    private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//    private static ClientDao clientDao;
//    private static List<Client> clients = new ArrayList<>();
//    private static final int COUNT_CLIENTS_IN_DB = 20;
//
//
//    @BeforeClass
//    public static void setUp(){
//        context.load("root-config.xml");
//        context.load("db/test/hibernate-datasource-test.xml");
//
//        context.refresh();
//
//        clientDao = (ClientDao) context.getBean("clientDaoHibernate");
//
//
//        for(int i = 0; i < COUNT_CLIENTS_IN_DB; i++){
//            Client client  = new Client();
//            client.setBirthDay(LocalDate.of(1994,7,31));
//            client.setPhone_number(11  * i);
//            client.setPassword("hibernate_pass_" + i);
//            client.setFirstName("hibernate_testFN_" + i);
//            client.setLastName("hibernate_testLN_" + i);
//
//            clients.add(client);
//        }
//    }
//
//    @Test
//    public void findAll_Test(){
//        List<Client> clients =  clientDao.findAll();
//        assertTrue(clients.size() > 0);
//        assertEquals(clients.get(1).getId(),2);
//        assertEquals("Filip",clients.get(1).getFirstName());
//        assertEquals(clients.get(0).getId(),1);
//        assertEquals("Eugen",clients.get(0).getFirstName());
//
//    }
//
//
//    @Test
//    public void selectAllClients_Bad_Param_Test(){
//
//
//        List<Client> clients =  clientDao.findAll();
//
//        assertNotEquals(clients.get(0).getId(),-1);
//        assertNotEquals(clients.get(0).getFirstName(),"anyString");
//
//    }
//    @Test
//    public void insert_Client_Test(){
//        //Save Client to DataBase
//        Client client = null;
//        for(int i = 0; i < clients.size(); i++){
//            client =  clients.get(i);
//            clientDao.save(client);
//        }
//
//        //Get Client with DataBase
//        Client clientWithDB = clientDao.findById(client.getId());
//        assertNotNull(clientWithDB);
//        assertEquals(clientWithDB,client);
//
//
//
//
//    }
//    @Test(expected = NoResultException.class)
//    public void delete_by_id_Test(){
//        Client client = clients.get(0);
//        clientDao.deleteById(client.getId());
//        Client clientWithDB = clientDao.findById(client.getId());
//
//        assertNull(clientWithDB);
//
//
//    }
//    @Test(expected = NoResultException.class)
//    public void delete_by_id_bad_param_Test(){
//        Client client = clients.get(1);
//        clientDao.deleteById(client.getId());
//        Client clientWithDB  = clientDao.findById(client.getId());
//
//        assertNull(clientWithDB);
//
//
//
//    }
//
//    @Test(expected = NoResultException.class)
//    public void delete_Test(){
//        Client client = clients.get(3);
//        clientDao.delete(client);
//        Client clientWithDB =  clientDao.findById(client.getId());
//
//        assertNull(clientWithDB);
//
//
//    }
//
//    @Test
//    public void update_Test(){
//        Client client = clientDao.findById(1L);
//        client.setPhone_number(1230);
//        clientDao.update(client);
//
//
//        Client clientWithDB = clientDao.findById(client.getId());
//
//
//        assertEquals(client,clientWithDB);
//    }
//
//    @Test
//    public void id_clients_not_equals_Test(){
//        Client client1  = clientDao.findById(1);
//        Client client2  = clientDao.findById(2);
//        assertNotEquals(client1,client2);
//        assertNotEquals(client1.getId(),client2.getId());
//    }
//
//
//}
//
//
