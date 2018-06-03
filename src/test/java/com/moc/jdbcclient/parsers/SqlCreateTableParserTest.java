package com.moc.jdbcclient.parsers;

import com.moc.jdbcclient.exceptions.InvalidSyntaxException;
import com.moc.jdbcclient.queries.QueryCreateTable;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SqlCreateTableParserTest {

    String sql;
    SqlCreateTableParser parser;

    @Before
    public void before() {
        parser = new SqlCreateTableParser();
        sql = "CREATE TABLE tableName (columnName1 dataType1, columnName2 dataType2)";
    }

    @Test
    public void testRetrieveEntityName() {
        String tableName = parser.retrieveEntityName(sql);
        assertEquals("tableName", tableName);
    }

    @Test(expected = InvalidSyntaxException.class)
    public void testRetrieveEntityNameInvalidSql() {
        String invalidSql = "CREATE CREATE TABLE tableName (columnName1 dataType1, ..)";
        String tableName = parser.retrieveEntityName(invalidSql);
        assertEquals("tableName", tableName);
    }

    @Test(expected = InvalidSyntaxException.class)
    public void testRetrieveEntityNameInvalidSql1() {
        String invalidSql = "CREATE TABLE tableName ";
        String tableName = parser.retrieveEntityName(invalidSql);
        assertEquals("tableName", tableName);
    }

    @Test
    public void testGetColumnNamesAndDataTypesList() {
        List<String> list = parser.getColumnNamesAndDataTypesList(sql, "CREATE TABLE tableName");
        List<String> listExpected = new ArrayList<>();
        listExpected.add("columnName1 dataType1");
        listExpected.add(" columnName2 dataType2");
        assertTrue(listExpected.equals(list));
    }

    @Test
    public void testGetColumnNamesAndDataTypesMap() {
        List<String> list = new ArrayList<>();
        list.add("columnName1 dataType1");
        list.add(" columnName2 dataType2");
        Map<String,String> map = parser.getColumnNamesAndDataTypesMap(list);
        Map<String,String> mapExpected = new HashMap<>();
        mapExpected.put("columnName1","dataType1");
        mapExpected.put("columnName2","dataType2");
        assertTrue(mapExpected.equals(map));
    }

    @Test
    public void testParse() {
        QueryCreateTable queryCreateTable = (QueryCreateTable) parser.parse(sql);
        Map<String,String> mapExpected = new HashMap<>();
        mapExpected.put("columnName1","dataType1");
        mapExpected.put("columnName2","dataType2");
        QueryCreateTable expectedQuery = new QueryCreateTable();
        expectedQuery.setColumnNamesAndDataTypesMap(mapExpected);
        expectedQuery.setEntityName("tableName");
        expectedQuery.setEntityType("TABLE");
        expectedQuery.setOperatorType("CREATE");
        assertEquals(expectedQuery.toString(), queryCreateTable.toString());
    }
}
