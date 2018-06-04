package com.moc.jdbcclient.executors;

import com.moc.jdbcclient.enums.Entity;
import com.moc.jdbcclient.enums.Operator;
import com.moc.jdbcclient.parsers.SqlParser;
import com.moc.jdbcclient.queries.Query;
import com.moc.jdbcclient.queries.QueryCreateDataBase;
import com.moc.jdbcclient.queries.QueryCreateTable;
import com.moc.jdbcclient.results.QueryResult;

import java.io.*;
import java.sql.*;

public class QueryExecutor implements Statement {

    private String resultMessage;
    private int updateCount = 0;
    private boolean isSelectOperator = false;



    Writer serverWriter;
    Reader reader;
    //QueryGenerator queryGenerator = new QueryGenerator();
    SqlParser parser = new SqlParser();

    public QueryExecutor(BufferedWriter writer, BufferedReader reader) {
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private QueryResult resultSet;

    @Override
    public boolean execute(String sql) throws SQLException {
        String query22 = queryGenerator.generateQuery(sql);
        try {
            serverWriter.write(query22);
            System.out.println("query server with query: " + query22);
            // String xml = reader.
        } catch (IOException e) {
            e.printStackTrace();
        }




        SqlParser parser = new SqlParser();
        Query query = (Query) parser.parse(sql);
        if ((Operator.CREATE.name()).equals(query.getOperatorType())) {
            if ((Entity.DATABASE.name().equals(query.getEntityType()))) {
                QueryCreateDataBase queryCreateDataBase = (QueryCreateDataBase) query;
                resultMessage = CreateDataBaseExecutor.process(queryCreateDataBase);
            } else {
                QueryCreateTable queryCreateTable = (QueryCreateTable) query;
                resultMessage = CreateTableExecutor.process(queryCreateTable);
            }
        } else if ((Operator.INSERT.name()).equals(query.getOperatorType())) {
            updateCount = 1;
            //todo
        } else if ((Operator.SELECT.name()).equals(query.getOperatorType())) {
            isSelectOperator = true;
            //todo
        } else if ((Operator.UPDATE.name()).equals(query.getOperatorType())) {
            updateCount = 1;
            //todo
        } else if ((Operator.DELETE.name()).equals(query.getOperatorType())) {
            updateCount = 1;
            //todo
        } else if ((Operator.DROP.name()).equals(query.getOperatorType())) {

            //todo
        }
        return isSelectOperator;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return resultSet;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return updateCount;
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return null;
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        return 0;
    }

    @Override
    public void close() throws SQLException {

    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return 0;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {

    }

    @Override
    public int getMaxRows() throws SQLException {
        return 0;
    }

    @Override
    public void setMaxRows(int max) throws SQLException {

    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {

    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return 0;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {

    }

    @Override
    public void cancel() throws SQLException {

    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public void setCursorName(String name) throws SQLException {

    }


    @Override
    public boolean getMoreResults() throws SQLException {
        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {

    }

    @Override
    public int getFetchDirection() throws SQLException {
        return 0;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {

    }

    @Override
    public int getFetchSize() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        return 0;
    }

    @Override
    public void addBatch(String sql) throws SQLException {

    }

    @Override
    public void clearBatch() throws SQLException {

    }

    @Override
    public int[] executeBatch() throws SQLException {
        return new int[0];
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return null;
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return 0;
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return 0;
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        return 0;
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return false;
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return false;
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return 0;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {

    }

    @Override
    public boolean isPoolable() throws SQLException {
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
