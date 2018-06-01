package com.moc.serverxml.parsers.sqlparser;

import com.moc.serverxml.enums.Entity;
import com.moc.serverxml.exceptions.InvalidSyntaxException;
import com.moc.serverxml.exceptions.Message;
import com.moc.serverxml.parsers.Parser;
import com.moc.serverxml.queries.QueryCreateDataBase;

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
