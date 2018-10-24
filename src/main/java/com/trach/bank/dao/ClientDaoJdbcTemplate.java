package com.trach.bank.dao;

import com.trach.bank.dao.crud.CustomerRowMapper;
import com.trach.bank.dao.crud.InsertClient;
import com.trach.bank.dao.crud.SelectAllClients;
import com.trach.bank.dao.crud.UpdateClient;
import com.trach.bank.model.Client;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientDaoJdbcTemplate implements ClientDao,InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SelectAllClients selectAllClients;
    private InsertClient insertClient;
    private UpdateClient updateClient;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        selectAllClients = new SelectAllClients(dataSource);
        insertClient = new InsertClient(dataSource);
        updateClient = new UpdateClient(dataSource);
    }

    @Override
    public List<Client> findAll() {
        return selectAllClients.execute();
    }

    @Override
    public Client findById(long id) {
        String sql = "SELECT id,first_name,last_name,password,email,birth_day,phone_number FROM clients WHERE id = :id";
        Map<String,Object> mapParam = new HashMap();
        mapParam.put("id",id);
        Client client = jdbcTemplate.queryForObject(sql,mapParam, (RowMapper<Client>) new CustomerRowMapper());
        return client;
    }

    @Override
    public void save(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("first_name",client.getFirstName());
        mapParam.put("last_name",client.getLastName());
        mapParam.put("password",client.getPassword());
        mapParam.put("email",client.getLogin());
        mapParam.put("birth_day",client.getBirthDay());
        mapParam.put("phone_number",client.getPhone_number());

        insertClient.updateByNamedParam(mapParam,keyHolder) ;
        client.setId(keyHolder.getKey().longValue());
    }

    @Override
    public String findFirstNameById(long id) {
        String sql = "SELECT first_name FROM clients WHERE id = :id";
        Map<String,Object> mapParam = new HashMap();
        mapParam.put("id",id);
       return jdbcTemplate.queryForObject(sql,mapParam,String.class);
    }

    @Override
    public void update(Client client) {
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("first_name", client.getFirstName());
        mapParam.put("last_name", client.getLastName());
        mapParam.put("password", client.getPassword());
        mapParam.put("email",client.getLogin());
        mapParam.put("phone_number", client.getPhone_number());
        mapParam.put("birth_day", client.getBirthDay());
        mapParam.put("id", client.getId());

        updateClient.updateByNamedParam(mapParam);

    }

    @Override
    public void delete(Client client) {
        deleteById(client.getId());
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE FROM clients  WHERE id= :id";
        Map<String,Object> mapParam = new HashMap<>();
        mapParam.put("id",id);
        jdbcTemplate.update(sql,mapParam);

    }

    @Override
    public Client getByLogin(String login) {
        String sql = "SELECT id,first_name,last_name,login,password,birth_day,phone_number FROM clients WHERE login = :login";
        Map<String,Object> mapParam = new HashMap();
        mapParam.put("login",login);
        Client client = jdbcTemplate.queryForObject(sql,mapParam, (RowMapper<Client>) new CustomerRowMapper());
        return client;
    }

    @Override
    public void afterPropertiesSet() throws BeanCreationException {
        if(dataSource == null){
            throw new BeanCreationException("Must set datasource on ClientDao");
        }

    }
}


