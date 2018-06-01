package com.moc.serverxml.xml;

import java.util.List;

public class XmlBuilder  {

    public static String generate(String entityType, String entityName) {
        StringBuilder builder = new StringBuilder();
        builder.append("<entityType>\n");
        builder.append(entityType);
        builder.append(">\n");
        builder.append("  <name>");
        builder.append(entityName);
        builder.append("</name>\n");
        builder.append("</");
        builder.append(entityType);
        builder.append(">\n");
        return builder.toString();
    }
    //list: or fields&dataTypes, or fields&data
    public static void generate(List<List<String>> list) {

    }

}
