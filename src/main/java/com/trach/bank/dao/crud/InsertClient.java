package com.trach.bank.dao.crud;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertClient extends SqlUpdate {

    private DataSource dataSource;
    private static final String sql = "INSERT INTO clients (first_name,last_name,password,email,phone_number,birth_day) VALUES" +
            "(:first_name,:last_name,:password,:email,:phone_number,:birth_day)";

    public InsertClient(DataSource dataSource){
        super(dataSource,sql);
        this.dataSource = dataSource;
        declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        declareParameter(new SqlParameter("password", Types.VARCHAR));
        declareParameter(new SqlParameter("email", Types.VARCHAR));
        declareParameter(new SqlParameter("phone_number", Types.INTEGER));
        declareParameter(new SqlParameter("birth_day", Types.DATE));
        setGeneratedKeysColumnNames("id");
        setReturnGeneratedKeys(true);

    }

}
