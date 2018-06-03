package com.moc.jdbcclient.parsers;

import com.moc.jdbcclient.enums.Entity;
import com.moc.jdbcclient.enums.Operator;
import com.moc.jdbcclient.exceptions.InvalidSyntaxException;
import com.moc.jdbcclient.exceptions.Message;
import com.moc.jdbcclient.queries.QueryCreateTable;

import java.util.*;

public class SqlCreateTableParser implements Parser {

    @Override
    public Object parse(Object object) {
        String sql = (String) object;
        if (sql.contains("TABLE")) {
            QueryCreateTable query = new QueryCreateTable();
            String tableName = retrieveEntityName(sql);
            query.setEntityName(tableName);
            query.setEntityType(Entity.TABLE.name());
            String tableDelimiter = Delimiter.getDelimiter("CREATE TABLE", tableName);
            List<String> list = getColumnNamesAndDataTypesList(sql, tableDelimiter);
            Map<String, String> map = getColumnNamesAndDataTypesMap(list);
            query.setColumnNamesAndDataTypesMap(map);
            return query;
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
        }
    }

    // list of "columnName1 dataType1"
    List<String> getColumnNamesAndDataTypesList(String sql, String tableDelimiter) {
        // EXAMPLE_CREATE_TABLE: CREATE TABLE tableName (columnName1 dataType1, ..)
        // split by next delimiter: tableDelimiter = "CREATE TABLE tableName"
        String[] array = sql.split(tableDelimiter);
        if (array.length != 2) {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
        }
        // get next string "(columnName1 dataType1, ..)"
        String line = array[1].trim();

        if (line.startsWith("(") && line.endsWith(")")) {
            line = line.substring(1, line.length() - 1);
            if (line.contains("(") || line.contains(")")) {
                throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
            }
        }

        // get next elements of array "columnName1 dataType1"
        String[] columnNameAndDataTypeArray = line.split(",");
        List<String> list = Arrays.asList(columnNameAndDataTypeArray);
        return list;
    }

    // key is columnName, value is dataType
    Map<String, String> getColumnNamesAndDataTypesMap(List<String> columnNamesAndDataTypesList) {
        Map<String, String> map = new HashMap<>();
        for (String line : columnNamesAndDataTypesList) {
            line = line.trim();
            String[] array = line.split(" ");
            if (array.length != 2) {
                throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
            }
            String columnName = array[0];
            String dataType = array[1];
            map.put(columnName, dataType);
        }
        return map;
    }

    String retrieveEntityName(String sql) {
        // EXAMPLE_CREATE_TABLE: CREATE TABLE tableName (columnName1 dataType1, ..)
        String[] array = sql.split(" ");
        if ( (Operator.CREATE.name().equals(array[0]) && (Entity.TABLE.name()).equals(array[1])) ) {
            String name = array[2];
            if (array.length > 3) {
                return name;
            } else {
                throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
            }
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
        }
    }
}
