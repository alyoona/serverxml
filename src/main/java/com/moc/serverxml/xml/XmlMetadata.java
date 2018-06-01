package com.moc.serverxml.xml;

import com.moc.serverxml.connection.Connection;
import com.moc.serverxml.enums.Entity;
import com.moc.serverxml.enums.Operator;
import com.moc.serverxml.queries.Query;
import com.moc.serverxml.queries.QueryCreate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class XmlMetadata implements Generator {

    Query query;

    public XmlMetadata(Query query) {
        this.query = query;
    }

    public void generate() {
        String operator = query.getOperatorType();
        if ((Operator.CREATE.name()).equals(operator)) {
            QueryCreate queryCreate = (QueryCreate) query;
            String entityType = queryCreate.getEntityType();
            if ((Entity.DATABASE.name()).equals(entityType)) {
                String  dataBaseName = queryCreate.getEntityName();
                Connection.setProperty(dataBaseName);
                String xml = XmlBuilder.generate(entityType, dataBaseName);


            }
        }
    }
}
