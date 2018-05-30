package com.moc.serverxml.xml;

import java.util.Map;

public class XmlMetadata implements Generator {

    Map<String, String> columnsAndDataTypes;

    public XmlMetadata(Map<String, String> map) {
        this.columnsAndDataTypes = map;
    }

    public XmlMetadata() {

    }

    public void generate() {

    }
}
