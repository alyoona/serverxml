package com.moc.serverxml.xml;

import java.util.List;

public class XmlBuilder  {

    public static String generate(String dataBaseName) {
        StringBuilder builder = new StringBuilder();
        builder.append("<dataBase>\n");
        builder.append("  <name>");
        builder.append(dataBaseName);
        builder.append("</name>\n");
        builder.append("</dataBase>\n");
        return builder.toString();
    }
    //list: or fields&dataTypes, or fields&data
    public static void generate(List<List<String>> list) {

    }

}
