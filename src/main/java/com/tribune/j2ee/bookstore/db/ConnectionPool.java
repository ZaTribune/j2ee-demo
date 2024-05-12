package com.tribune.j2ee.bookstore.db;

import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPool {

    private DataSource dataSource;

    public ConnectionPool() {
        try {
            dataSource = JdbcConnectionPool.create(
                    "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user", "password");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE,
                    null, ex);
            return null;
        }
    }

    private static class ConnectionPoolHolder {
        public static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }
}
