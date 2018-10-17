package com.trach.bank.dao;


import com.trach.bank.model.Client;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDaoJdbcTemplate_Test {
    private static ClientDaoJdbcTemplate dao;
    private static List<Client> clients = new ArrayList<>();
    private static final int COUNT_CLIENTS_IN_DB = 20;

    @BeforeClass
    public static void setUp(){

        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/test/sql/createDb.sql")
                .addScript("db/test/sql/insertTestData.sql")
                .build();
        dao = new ClientDaoJdbcTemplate();
        dao.setDataSource(dataSource);

    for(int i = 0; i < COUNT_CLIENTS_IN_DB; i++){
        Client client  = new Client();
        client.setBirthDay(LocalDate.of(2018,10,9));
        client.setPhone_number(11  * i);
        client.setPassword("pass_" + i);
        client.setFirstName("testFN_" + i);
        client.setLastName("testLN_" + i);

        clients.add(client);
            }
    }

    @Test
    public void findById_Test(){
        Client client = new Client();
        client.setFirstName("Eugen");
        client.setLastName("Trach");
        client.setId(1L);
        client.setPhone_number(67389042);
        client.setPassword("qwerty");
        client.setBirthDay(LocalDate.of(1994,7,13));
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
        assertEquals("Filip",clients.get(1).getFirstName());
    }

    @Test
    public void selectAllClients_Bad_Param_Test(){


        List<Client> clients =  dao.findAll();

        assertNotEquals(clients.get(0).getId(),-1);
        assertNotEquals(clients.get(0).getFirstName(),"anyString");

    }
    @Test
    public void insert_Client_Test(){
        //Save Client to DataBase
        Client client = null;
        for(int i = 0; i < clients.size(); i++){
           client =  clients.get(i);
            dao.save(client);
        }

        //Get Client with DataBase
        Client clientWithDB = dao.findById(client.getId());

        assertEquals(clientWithDB,client);
        assertNotNull(clientWithDB);



    }
    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_by_id_Test(){
        Client client = clients.get(0);
        dao.deleteById(client.getId());
        Client clientWithDB = dao.findById((client.getId()));

        assertNull(clientWithDB);


    }
    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_by_id_bad_param_Test(){
        Client client = clients.get(1);
        dao.deleteById(client.getId());
        Client clientWithDB  = dao.findById(client.getId());

        assertNull(clientWithDB);



    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void delete_Test(){
        Client client = clients.get(3);
        dao.delete(client);
        Client clientWithDB =  dao.findById(client.getId());

        assertNull(clientWithDB);


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

