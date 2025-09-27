package org.j2os.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC {
    private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

    static {
        DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
        DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        DATA_SOURCE.setUsername("system");
        DATA_SOURCE.setPassword("123456");
        DATA_SOURCE.setMaxTotal(10);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
