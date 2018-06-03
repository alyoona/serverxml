package com.moc.jdbcclient.parsers;

import com.moc.jdbcclient.enums.Entity;
import com.moc.jdbcclient.enums.Operator;
import com.moc.jdbcclient.exceptions.InvalidSyntaxException;
import com.moc.jdbcclient.exceptions.Message;

public class SqlParser implements Parser {

    @Override
    public Object parse(Object object) {
        String sql = (String) object;
        Object query;
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

    static Object parseCreate(String sql) {
        Object query;
        if (sql.contains(Entity.TABLE.name())) {
            query = parseCreateTable(sql);
        } else if (sql.contains(Entity.DATABASE.name())) {
            query = parseCreateDataBase(sql);
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_CREATE);
        }
        return query;
    }

    private static Object parseDrop(String sql) {
        Object query;
        if (sql.contains(Entity.TABLE.name())) {
            query = parseDropTable(sql);
        } else if (sql.contains(Entity.DATABASE.name()))  {
            query = parseDropDataBase(sql);
        } else {
            throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE_DROP);
        }
        return query;
    }

    private static Object parseCreateDataBase(String sql) {
        SqlCreateDataBaseParser p = new SqlCreateDataBaseParser();
        return p.parse(sql);
    }

    private static Object parseCreateTable(String sql) {
        SqlCreateTableParser p = new SqlCreateTableParser();
        return p.parse(sql);
    }

    private static Object parseSelect(String sql) {
        SqlSelectParser sqlSelectParser = new SqlSelectParser();
        return sqlSelectParser.parse(sql);
    }

    private static Object parseInsert(String sql) {
        SqlInsertParser sqlInsertParser = new SqlInsertParser();
        return sqlInsertParser.parse(sql);
    }

    private static Object parseDelete(String sql) {
        SqlDeleteParser sqlDeleteParser = new SqlDeleteParser();
        return sqlDeleteParser.parse(sql);
    }

    private static Object parseUpdate(String sql) {
        SqlUpdateParser sqlUpdateParser = new SqlUpdateParser();
        return sqlUpdateParser.parse(sql);
    }

    private static Object parseDropDataBase(String sql) {
        SqlDropDataBaseParser sqlDropDataBaseParser = new SqlDropDataBaseParser();
        return sqlDropDataBaseParser.parse(sql);
    }

    private static Object parseDropTable(String sql) {
        SqlDropTableParser sqlDropTableParser = new SqlDropTableParser();
        return sqlDropTableParser.parse(sql);
    }
}
