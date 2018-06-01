package com.moc.serverxml.xml;


import com.moc.serverxml.connection.Connection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataBaseGenerator implements Generator {

    public DataBaseGenerator() {
    }

    @Override
    public void generate() {
        Connection.setProperty(dataBaseName);
        try {
            Files.createDirectory(Paths.get(dataBaseName));
        } catch (IOException e) {
            throw new RuntimeException("error while creating DataBase: " + dataBaseName);
        }
        XmlFileGenerator.create();
    }
}
