package com.moc.jdbcclient.queryqpp;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class QueryApp {
    public static void main(String[] args) {
        String sql = getSql(args);
        run(sql);
    }

    static void run(String sql) {
        try (Connection connection = SetUpDB.loadClassDriverAndGetConnection();
             Statement statement = connection.createStatement();
        ) {
            boolean isResult = statement.execute(sql);
            printInfo(sql);
            if (isResult) {
                try (ResultSet resultSet = statement.getResultSet()) {
//                    DBTablePrinter.printResultSet(resultSet);
//                    CreateHtml.print(resultSet);
                }
            } else {
                if (sql.contains("CREATE")) {
                    String tableName = getTableName(sql);
                    if (isExist(tableName)) {
                        System.out.println("Table " + tableName + " was created successfully.");
                    }
                } else if (sql.contains("DROP")) {
                    String tableName = getTableName(sql);
                    if (!isExist(tableName)) {
                        System.out.println("Table " + tableName + " was deleted successfully.");
                    }
                } else {
                    int countAffectedRows = statement.getUpdateCount();
                    System.out.println("Count affected rows: " + countAffectedRows);
                }
            }
        } catch (SQLException sqlExceptions) {
            for (Throwable sqlException : sqlExceptions) {
                sqlException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getSql(String[] args) {
        List<String> list = Arrays.asList(args);
        String sql = String.join(" ", list);
        sql = sql.toUpperCase().trim();
        if (sql.endsWith(";")) {
            sql = sql.substring(0, sql.length() - 1);
        }
        return sql;
    }

    private static void printInfo(String sql) {
        System.out.println("sql> " + sql);
        System.out.print("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]" + " ");
    }

    private static boolean isExist(String tableName) throws SQLException, IOException {
        String findTable = getQuery(tableName);
        try (Connection connection = SetUpDB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findTable)) {
            return rs.next();
        }
    }

    private static String getQuery(String tableName) {
        StringBuilder builder = new StringBuilder("SELECT 1 ");
        builder.append("FROM MY_DB.INFORMATION_SCHEMA.TABLES ");
        builder.append("WHERE TABLE_NAME = '");
        builder.append(tableName);
        builder.append("'");
        return builder.toString();
    }

    private static String getTableName(String sql) {
        String[] array = sql.split("TABLE");
        String tableName = array[1].trim();
        if (tableName.contains("(")) {
            String[] t = tableName.split("\\(");
            tableName = t[0];
        }
        //only for drop or create statement
        return tableName;
    }

    private static String getTableName(ResultSet resultSet) throws SQLException {
        ResultSetMetaData md = resultSet.getMetaData();
        //doesn't work if existing table is empty(without columns), return null
        return md.getTableName(1);
    }

}
