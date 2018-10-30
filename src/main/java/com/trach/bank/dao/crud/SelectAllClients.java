package com.trach.bank.dao.crud;

import com.trach.bank.model.Client;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllClients extends MappingSqlQuery<Client>  {
            private  final CustomerRowMapper customerRowMapper = new CustomerRowMapper();
            private static final String sql = "SELECT id, first_name, last_name, password,role,login, phone_number , birth_day " +
                    " FROM clients";

            public SelectAllClients(DataSource dataSource) {
                super(dataSource,sql);
            }


            @Override
            public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
               return (Client) customerRowMapper.mapRow(resultSet,rowNum);
            }
        }

