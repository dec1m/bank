package com.trach.bank.dao.crud;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateClient extends SqlUpdate {
    private static String sql = "UPDATE clients SET first_name = :first_name, last_name = :last_name,password = :password," +
            "birth_day = :birth_day,phone_number = :phone_number WHERE id = :id";
    public UpdateClient(DataSource dataSource){
        super(dataSource,sql);
        declareParameter(new SqlParameter("first_name", Types.VARCHAR));
        declareParameter(new SqlParameter("last_name", Types.VARCHAR));
        declareParameter(new SqlParameter("password", Types.VARCHAR));
        declareParameter(new SqlParameter("birth_day", Types.DATE));
        declareParameter(new SqlParameter("phone_number", Types.INTEGER));
        declareParameter(new SqlParameter("id", Types.INTEGER));

    }
}
