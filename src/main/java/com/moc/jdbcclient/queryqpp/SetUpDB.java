package com.moc.jdbcclient.queryqpp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetUpDB {
    public static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("db.properties"))
        ){
            properties.load(inputStream);
        }
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

    public static Connection loadClassDriverAndGetConnection() {
        try {
            Class.forName("com.moc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("error while Driver Class loading ", e);
        }
        try {
            return DriverManager.getConnection("3000", "user", "user");
        } catch (SQLException e) {
            throw new RuntimeException("error while getting connection ", e);
        }
    }
}
