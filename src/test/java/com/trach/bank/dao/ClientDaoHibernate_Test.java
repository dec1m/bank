//package com.trach.bank.dao;
//
//
//
//import com.trach.bank.model.Client;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import javax.persistence.NoResultException;
//import java.time.LocalDate;
//
//
//import static junit.framework.TestCase.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//
//
//public class ClientDaoHibernate_Test {
//
//    private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//    private ClientDao dao;
//
//
//    @BeforeClass
//    public static void setUpClass(){
//        context.load("root-config.xml");
//        context.load("db/test/hibernate-datasource-test.xml");
//        context.refresh();
//    }
//    @Before
//    public void setUp(){
//
//        dao = (ClientDao) context.getBean("clientDao");
//
//
//
//    }
//
//
//    @Test
//    public void findById_Test(){
//        Client client = new Client();
//        client.setId(1);
//        client.setBirthDay(LocalDate.of(1994,7,13));
//        client.setFirstName("Eugen");
//        client.setLastName("Trach");
//        client.setPassword("123123");
//        client.setLogin("decim");
//        client.setPhone_number(67389042);
//       assertEquals(client,dao.findById(1));
//    }
//
//    @Test
//    public void findById_Bad_Param_Test(){
//
//        Client clientBad = new Client();
//        clientBad.setId(999);
//        clientBad.setBirthDay(LocalDate.of(1111,1,11));
//        clientBad.setFirstName("BAD_PARAM");
//        clientBad.setLastName("BAD_PARAM");
//        clientBad.setPassword("BAD_PARAM");
//        clientBad.setLogin("BAD_PARAM");
//        clientBad.setPhone_number(1111);
//        assertNotEquals(clientBad,dao.findById(1));
//    }
//
//    @Test
//    public void getByLogin_Test(){
//        Client client = new Client();
//        client.setId(1);
//        client.setBirthDay(LocalDate.of(1994,7,13));
//        client.setFirstName("Eugen");
//        client.setLastName("Trach");
//        client.setPassword("123123");
//        client.setLogin("decim");
//        client.setPhone_number(67389042);
//
//        Client actual = dao.findByLogin("decim");
//        assertEquals(client,actual);
//    }
//    @Test(expected = NoResultException.class)
//    public void getByLogin_null_Test(){
//
//
//        Client actual = dao.findByLogin("null");
//
//    }
//
//
//    //Dependent  dao.findByLogin();
//    @Test
//    public void persist_Test(){
//       Client persistClient = new Client();
//        persistClient.setBirthDay(LocalDate.of(1994,7,13));
//        persistClient.setFirstName("persist_Test");
//        persistClient.setLastName("persist_Test");
//        persistClient.setPassword("persist_Test");
//        persistClient.setLogin("persist_Test");
//        persistClient.setPhone_number(67389042);
//
//        dao.save(persistClient);
//
//      Client actual = dao.findByLogin("persist_Test");
//
//       assertEquals(persistClient,actual);
//
//
//
//    }
//
//
//    @Test(expected = NoResultException.class)
//    public void delete_Test(){
//        Client deleteClient = new Client();
//        deleteClient.setBirthDay(LocalDate.of(1994,7,13));
//        deleteClient.setFirstName("deleteClient");
//        deleteClient.setLastName("deleteClient");
//        deleteClient.setPassword("deleteClient");
//        deleteClient.setLogin("deleteClient");
//        deleteClient.setPhone_number(67389042);
//        dao.save(deleteClient);
//        dao.delete(deleteClient);
//        dao.findByLogin("deleteClient");
//
//
//    }
//
//    @Test
//    public void update_Test(){
//        Client client = new Client();
//        client.setId(1);
//        client.setBirthDay(LocalDate.of(1994,7,13));
//        client.setFirstName("EugenUpdate");
//        client.setLastName("Trach");
//        client.setPassword("123123");
//        client.setLogin("decim");
//        client.setPhone_number(67389042);
//
//        dao.update(client);
//        Client actual = dao.findById(1);
//
//        assertEquals(client,actual);
//    }
//
//
//
//
//}
//
//
