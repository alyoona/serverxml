package com.moc.serverxml.queries;

import com.moc.serverxml.enums.Entity;
import com.moc.serverxml.enums.Operator;
import com.moc.serverxml.exceptions.InvalidSyntaxException;
import com.moc.serverxml.exceptions.Message;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static Query parse(String sql) {
        Query query;
        if (sql.contains(Operator.CREATE.name())) {
            query = parseCreate(sql);
        } else if (sql.contains(Operator.INSERT.name())) {
            query = parseInsert(sql);
        } else if (sql.contains(Operator.SELECT.name())) {
            query = parseSelect(sql);
        } else if (sql.contains(Operator.UPDATE.name())) {
            query = parseUpdate(sql);
        } else if (sql.contains(Operator.DELETE.name())) {
            query = parseDelete(sql);
        } else if (sql.contains(Operator.DROP.name())) {
            query = parseDrop(sql);
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE);
        }
        return query;
    }

    static Query parseCreate(String sql) {
        QueryCreate query = new QueryCreate();

        String delimiter = getDelimiter(Operator.CREATE.name(), Entity.TABLE.name());
        if (sql.contains(delimiter)) {
            String tableName = getEntityNameFromCreateOrDrop(sql, delimiter);
            query.setEntityName(tableName);
            query.setEntityType(Entity.TABLE.name());
        } else {
            delimiter = getDelimiter(Operator.CREATE.name(), Entity.DATABASE.name());
            if (sql.contains(delimiter)) {
                String dbName = getEntityNameFromCreateOrDrop(sql, delimiter);
                query.setEntityName(dbName);
                query.setEntityType(Entity.DATABASE.name());
            } else {
                throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE);
            }
        }
        query.setOperatorType(Operator.CREATE.name());
        return query;
    }

    private static String getEntityNameFromCreateOrDrop(String sql, String delimiter) {
        String[] array = sql.split(delimiter);
        String name = array[1].trim();
        if (array.length == 2 && !name.contains(" ")) {
            return name;
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE);
        }
    }

    static String getDelimiter(String... args) {
        List<String> list = Arrays.asList(args);
        return String.join(" ", list);
    }

    private static Query parseSelect(String sql) {
        return null;
    }

    private static Query parseInsert(String sql) {
        return null;
    }

    private static Query parseDrop(String sql) {
        return null;
    }

    private static Query parseDelete(String sql) {
        return null;
    }

    private static Query parseUpdate(String sql) {
        return null;
    }
}
