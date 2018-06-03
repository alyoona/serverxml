package com.moc.jdbcclient.xml;

import com.moc.jdbcclient.connection.Connection;
import com.moc.jdbcclient.queries.Query;
import com.moc.jdbcclient.queries.QueryCreateTable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public final class XMLUtil {


    public static void write(Document doc, OutputStream out) throws IOException {
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Source source = new DOMSource(doc);

            Result result = new StreamResult(out);
            t.transform(source, result);
        } catch (Exception e) {
            throw (IOException) new IOException(e.toString()).initCause(e);
        } catch (TransformerFactoryConfigurationError e) {
            throw (IOException) new IOException(e.toString()).initCause(e);
        }
    }

    public static void generateTableXml(String entityName) throws ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element table = doc.createElement(entityName);
        doc.appendChild(table);//root: </table>
        String tableXmlpath = getTableFolderPath(entityName) + entityName + ".xml";
        write(doc, new FileOutputStream(tableXmlpath));
    }

    public static void generateTableMetaDataXml(String entityName, Map<String, String> columnNamesAndDataTypesMap) throws ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element table = doc.createElement(entityName);
        doc.appendChild(table);//<table>
        Set entries = columnNamesAndDataTypesMap.entrySet();
        for (Object obj : entries) {
            Map.Entry entry = (Map.Entry) obj;
            Element columnName = doc.createElement(entry.getKey().toString());
            table.appendChild(columnName);
            Element columnDataType = doc.createElement("columnDataType");
            columnName.appendChild(columnDataType);
            Text text = doc.createTextNode(entry.getValue().toString());
            columnDataType.appendChild(text);
        }
        String tableMetaDataXmlPath = getTableFolderPath(entityName)+ entityName + "MetaData.xml";
        XMLUtil.write(doc, new FileOutputStream(tableMetaDataXmlPath));
    }

    public static void createTableFolder(String entityName) throws IOException {
        String rootPath = Connection.getDB();
        String tableFolderPath = rootPath + File.separator + entityName;
        Files.createDirectory(Paths.get(tableFolderPath));
    }

    public static void createDataBaseFolder(String entityName) {
        Connection.setProperty(entityName);
        try {
            Files.createDirectory(Paths.get(entityName));
        } catch (IOException e) {
            throw new RuntimeException("error while creating DataBaseFolder", e);
        }
    }


    private static String getTableFolderPath(String entityName) {
        String rootPath = Connection.getDB();
        String tableFolderPath = rootPath + File.separator + entityName;
        return tableFolderPath;
    }

    public static void generateDataBaseMetaDataXml(String entityName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("error while creating DocumentBuilder", e);
        }
        Document doc = builder.newDocument();
        Element dataBase = doc.createElement("dataBase");
        doc.appendChild(dataBase);//root: </dataBase>
        Text dataBaseName = doc.createTextNode(entityName);
        dataBase.appendChild(dataBaseName);
        String dataBaseXmlPath = Connection.getDB() + File.separator + entityName + "MetaData.xml";
        doc.toString();
        try {
            write(doc, new FileOutputStream(dataBaseXmlPath));
        } catch (IOException e) {
            throw new RuntimeException("error while creating dataBaseMetaDataXml", e);
        }
    }

    static String getXMLString(Document xmlDoc) throws Exception {
        DOMSource source = new DOMSource(xmlDoc.getDocumentElement());
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.transform(source, result);
        StringBuffer strBuf = writer.getBuffer();
        return strBuf.toString();
    }



}
