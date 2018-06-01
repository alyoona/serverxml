package com.moc.serverxml.parsers.sqlparser;

import com.moc.serverxml.enums.Entity;
import com.moc.serverxml.exceptions.InvalidSyntaxException;
import com.moc.serverxml.exceptions.Message;
import com.moc.serverxml.parsers.Parser;
import com.moc.serverxml.queries.QueryCreateTable;

import java.util.ArrayList;

public class SqlCreateTableParser implements Parser {
    @Override
    public Object parse(Object object) {
        String sql = (String) object;
        String delimiter = "CREATE TABLE";
        if (sql.contains(delimiter)) {
            String tableName = retrieveEntityName(sql, delimiter);
            QueryCreateTable query = new QueryCreateTable();
            query.setEntityName(tableName);
            query.setEntityType(Entity.TABLE.name());
            query.list = new ArrayList();//todo
            return query;
        }  else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
        }
    }

    private String retrieveEntityName(String sql, String delimiter) {
        String[] array = sql.split(delimiter);
        String name = array[1].trim();
        if (array.length == 2 && !name.contains(" ")) {
            return name;
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_TABLE);
        }
    }




}
