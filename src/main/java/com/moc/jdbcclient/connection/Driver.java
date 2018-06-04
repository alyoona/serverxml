package com.moc.jdbcclient.connection;

import java.io.IOException;
import java.net.Socket;
import java.sql.*;
import java.sql.Connection;
import java.util.Properties;
import java.util.logging.Logger;

public class Driver implements java.sql.Driver {

    static {
        Driver driver = new Driver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {


        try {
            Socket clientSocket = new Socket("localhost", 3000);
        } catch (IOException e) {
            throw  new RuntimeException("error connection ", e);
        }
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
