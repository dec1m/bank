package com.trach.bank.dao;

import com.trach.bank.model.Client;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import java.time.LocalDate;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class ClientDaoJdbcTemplate_Test {
    private static ClientDaoJdbcTemplate dao;
    private Client client;
    private Client clientBad;


    @BeforeClass
    public static void setUpClass(){

        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/test/sql/createDb.sql")
                .addScript("db/test/sql/insertTestData.sql")
                .build();
        dao = new ClientDaoJdbcTemplate();
        dao.setDataSource(dataSource);


    }
    @Before
    public void setUp(){
        client = new Client();
        client.setId(1);
        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("Eugen");
        client.setLastName("Trach");
        client.setPassword("123123");
        client.setRole("ROLE_USER");
        client.setLogin("decim");
        client.setPhone_number(67389042);


        clientBad = new Client();
        clientBad.setId(1123);
        clientBad.setBirthDay(LocalDate.of(1111,1,11));
        clientBad.setFirstName("BAD_PARAM");
        clientBad.setLastName("BAD_PARAM");
        clientBad.setPassword("BAD_PARAM");
        clientBad.setRole("BAD_PARAM");
        clientBad.setLogin("BAD_PARAM");
        clientBad.setPhone_number(1111);

    }

    @Test
    public void findById_Test(){

        Client fromDb = dao.findById(1);

        assertEquals(client,fromDb);
    }

    @Test
    public  void findFirstNameById_1_Eugen_Test(){
       String actual =  dao.findFirstNameById(1);
       String expected  = "Eugen";
        assertEquals(expected,actual);
    }
    @Test
    public  void findFirstNameById_1_Bad_Param_Eugen_Test(){
        String actual =  dao.findFirstNameById(1);
        String noExpected  = "anyString";
        assertNotEquals(noExpected,actual);

    }

    @Test
    public void selectAllClients_Test(){


        List<Client> clients =  dao.findAll();
        assertTrue(clients.size() > 0);
        assertEquals(clients.get(0).getId(),1);
        assertEquals("Eugen",clients.get(0).getFirstName());
        assertEquals(clients.get(1).getId(),2);
        assertEquals("Piotr",clients.get(1).getFirstName());
    }

    @Test
    public void selectAllClients_Bad_Param_Test(){


        List<Client> clients =  dao.findAll();

        assertNotEquals(clients.get(0).getId(),-1);
        assertNotEquals(clients.get(0).getFirstName(),"anyString");

    }

    @Test
    public void update_Test(){
        Client client = dao.findById(1);
        client.setPhone_number(61230);
        dao.update(client);


        Client clientWithDB = dao.findById(client.getId());


        assertEquals(client,clientWithDB);
    }

    @Test
    public void id_clients_not_equals_Test(){
        Client client1  = dao.findById(1);
        Client client2  = dao.findById(2);
        assertNotEquals(client1,client2);
        assertNotEquals(client1.getId(),client2.getId());
    }



}

