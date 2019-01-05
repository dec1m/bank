package com.trach.bank.services;

import com.trach.bank.dao.ClientDao;
import com.trach.bank.model.Client;
import com.trach.bank.model.Group;
import com.trach.bank.security.UserDetailsImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ClientDetailsServiceImplTest {

    private ClientDetailsServiceImpl clientDetailsService;



    @Before
    public void setUp(){

        clientDetailsService = new ClientDetailsServiceImpl();
        clientDetailsService.setClientDao(mock(ClientDao.class));
    }

    @Test
    public void loadUserByUserName_return_value_Test(){

        Client client = mock(Client.class);
        when(clientDetailsService.getClientDao().findByLogin(anyString())).thenReturn(client);
        when(client.getGroup()).thenReturn(mock(Group.class));
        Object o = clientDetailsService.loadUserByUsername(anyString());

        assertEquals(UserDetailsImpl.class, o.getClass());


    }
    @Test
    public void loadUserByUserName_client_in_UserDetailsImpl_Test(){
        String testName = "decim";
        Client client = new Client();
        client.setId(1);
        client.setBirthDay(LocalDate.of(1994,7,13));
        client.setFirstName("Eugen");
        client.setLastName("Trach");
        client.setPassword("123123");
        client.setLogin(testName);
        client.setGroup(mock(Group.class));
        client.setPhone_number(67389042);

        when(clientDetailsService.getClientDao().findByLogin(testName)).thenReturn(client);

        UserDetails userDetails = clientDetailsService.loadUserByUsername(testName);
        assertEquals(userDetails.getUsername(),client.getLogin());
    }
}
