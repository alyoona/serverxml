package com.moc.jdbcclient.parsers;

import com.moc.jdbcclient.enums.Entity;
import com.moc.jdbcclient.exceptions.InvalidSyntaxException;
import com.moc.jdbcclient.exceptions.Message;
import com.moc.jdbcclient.queries.QueryCreateDataBase;

public class SqlCreateDataBaseParser implements Parser {

    @Override
    public Object parse(Object object) {
        String sql = (String) object;
        String delimiter = "CREATE DATABASE";
        if (sql.contains(delimiter)) {
            String tableName = retrieveEntityName(sql, delimiter);
            QueryCreateDataBase query = new QueryCreateDataBase();
            query.setEntityName(tableName);
            query.setEntityType(Entity.DATABASE.name());
            return query;
        }  else {
                throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_DB);
            }
    }

    private String retrieveEntityName(String sql, String delimiter) {
        String[] array = sql.split(delimiter);
        String name = array[1].trim();
        if (array.length == 2 && !name.contains(" ")) {
            return name;
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE_DB);
        }
    }


}
