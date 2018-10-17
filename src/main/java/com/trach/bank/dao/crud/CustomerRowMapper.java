package com.trach.bank.dao.crud;

import com.trach.bank.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper  implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getLong("id"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setPassword(resultSet.getString("password"));
        client.setPhone_number(resultSet.getInt("phone_number"));
        client.setBirthDay(resultSet.getDate("birth_day").toLocalDate());
        return client;
    }
}
