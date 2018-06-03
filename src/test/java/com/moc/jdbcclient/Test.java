package com.moc.jdbcclient;

import com.moc.jdbcclient.queries.QueryCreateTable;
import com.moc.jdbcclient.xml.XMLUtil;

import com.sun.org.apache.xml.internal.security.utils.XMLUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Test {

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, IOException, SAXException {
        QueryCreateTable query = new QueryCreateTable();
        query.setEntityType("TABLE");
        query.setEntityName("my_table");
        Map<String, String> map = new HashMap<>();
        map.put("id", "INT");
        map.put("name", "CHAR(20)");
        query.setColumnNamesAndDataTypesMap(map);

        XMLUtil.generateNewTable(query);
        XMLUtil.generateTableMetaData(Map<String, String> map);


    }


}
