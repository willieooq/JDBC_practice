package com.mysql.db;

import java.sql.Connection;
import java.sql.Statement;

abstract class DataBase {
    protected Connection conn = null;
    protected Statement stmt = null;

    protected Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    protected Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}//end class
