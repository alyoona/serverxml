package com.moc.jdbcclient.queries;

import java.util.Map;

public class QueryInsert {

    private Map<String,String> columnNamesAndDatasMap;

    public Map<String, String> getColumnNamesAndDatasMap() {
        return columnNamesAndDatasMap;
    }

    public void setColumnNamesAndDatasMap(Map<String, String> columnNamesAndDatasMap) {
        this.columnNamesAndDatasMap = columnNamesAndDatasMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryCreateTable{");
        sb.append(super.toString());
        sb.append("columnNamesAndDatasMap=").append(columnNamesAndDatasMap);
        sb.append('}');
        return sb.toString();
    }
}
