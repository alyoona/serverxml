package com.moc.serverxml.xml;


import com.moc.serverxml.connection.Connection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class XmlFileGenerator {

    public static void create(String xml, String fileName) {
        String root = Connection.getDB();
        String path = root + File.separator + fileName + ".xml";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write(xml);
        } catch (IOException e) {
            throw new RuntimeException("error while creating xml", e);
        }
    }

}
