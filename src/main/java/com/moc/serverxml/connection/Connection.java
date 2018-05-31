package com.moc.serverxml.connection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Connection {

    public static void setProperty(String dataBaseName) {

        Properties properties = new Properties();
        properties.setProperty("dbPath", dataBaseName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db.properties"));) {
            properties.store(writer, "storing main dataBase catalog path");
        } catch (IOException e) {
            throw new RuntimeException("error while creating db.properties");
        }
    }

    public static String getDB() {
        Properties properties = new Properties();
        try (InputStream is = Files.newInputStream(Paths.get("db.properties"))) {

            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("error while reading db.properties");
        }
        return properties.getProperty("dbPath");
    }

}
