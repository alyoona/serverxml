package com.moc.serverxml.xml;

public class XmlFileGeneratorTest {

    public static void main(String[] args) {
        String xml = XmlBuilder.generate("My_DB");
        XmlFileGenerator.create(xml, "My_DB");
    }

}
