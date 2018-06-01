package com.moc.serverxml.queries;

import com.moc.serverxml.enums.Entity;
import com.moc.serverxml.enums.Operator;
import com.moc.serverxml.parsers.sqlparser.SqlParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseTest {

    @Test
    public void testGetDelimeter() {
        SqlParser parser = new SqlParser();
        String delimiter = parser.getDelimiter(Operator.CREATE.name(), Entity.DATABASE.name());
        assertEquals("CREATE DATABASE", delimiter);
    }

    @Test
    public void testParseCreate() {
        String sql = "CREATE DATABASE my_db";
        SqlParser parser = new SqlParser();
        Query queryCreateDB = parser.parseCreate(sql);
        String queryObject = "QueryCreate{entityType='DATABASE', entityName='my_db'}";
        assertEquals(queryObject, queryCreateDB.toString());
    }

}
