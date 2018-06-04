package com.moc.jdbcclient;

import com.moc.jdbcclient.connection.Connection;
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

        Document newDoc = XMLUtil.generateDataBaseMetaDataXml("my_dbdbdbd");
        String string = XMLUtil.convertDocumentToString(newDoc);
        System.out.println(string);


    }


}
