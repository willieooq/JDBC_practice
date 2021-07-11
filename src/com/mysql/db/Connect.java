package com.mysql.db;

import java.sql.*;

public class Connect {

    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/schema_test";
    // DB username and password
    private final String USER_NAME = "root";
    private final String PASSWORD = "admin";

    //connect function
    public Connection getConnect() throws SQLException,ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
        return conn;
    }
}//end class
