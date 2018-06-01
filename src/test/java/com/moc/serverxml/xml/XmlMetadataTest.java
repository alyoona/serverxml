package com.moc.serverxml.xml;


import com.moc.serverxml.parsers.Parser;
import com.moc.serverxml.queries.Query;

public class XmlMetadataTest {

    public static void main(String[] args) {
        String sql = "CREATE DATABASE my_db";
        Query query = Parser.parse(sql);
        XmlMetadata xmlMetadata = new XmlMetadata(query);
        xmlMetadata.generate();
    }
}
