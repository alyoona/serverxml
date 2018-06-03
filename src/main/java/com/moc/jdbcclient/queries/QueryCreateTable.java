package com.moc.jdbcclient.queries;


import java.util.Map;

public class QueryCreateTable extends Query {

    private Map<String,String> columnNamesAndDataTypesMap ;

    public Map<String, String> getColumnNamesAndDataTypesMap() {
        return columnNamesAndDataTypesMap;
    }

    public void setColumnNamesAndDataTypesMap(Map<String, String> columnNamesAndDataTypesMap) {
        this.columnNamesAndDataTypesMap = columnNamesAndDataTypesMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryCreateTable{");
        sb.append(super.toString());
        sb.append("columnNamesAndDataTypesMap=").append(columnNamesAndDataTypesMap);
        sb.append('}');
        return sb.toString();
    }



}
