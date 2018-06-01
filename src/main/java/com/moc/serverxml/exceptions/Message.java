package com.moc.serverxml.exceptions;

public class Message {
    public static final String EXAMPLE = getExample();
    public static final String EXAMPLE_CREATE = getExampleCreate();
    public static final String EXAMPLE_CREATE_DB = "CREATE DATABASE dbName";
    public static final String EXAMPLE_CREATE_TABLE = "CREATE TABLE tableName";
    public static final String EXAMPLE_INSERT = "INSERT INTO TABLE tableName (columnName1, ..) VALUES (value1, ..)";
    public static final String EXAMPLE_SELECT = "SELECT columnName1(,..) FROM tableName";
    public static final String EXAMPLE_UPDATE = "UPDATE tableName SET columnName1 = value1(, ..) (WHERE..) ";
    public static final String EXAMPLE_DELETE = "DELETE FROM tableName WHERE columnName1 = value1(, ..)";
    public static final String EXAMPLE_DROP = getExampleDrop();
    public static final String EXAMPLE_DROP_DB = "DROP DATABASE dbName";
    public static final String EXAMPLE_DROP_TABLE = "DROP TABLE tableName";


    private static String getExampleCreate() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append("or ");
        builder.append(EXAMPLE_CREATE_DB);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_CREATE_TABLE);
        return builder.toString();
    }
    private static String getExampleDrop() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append("or ");
        builder.append(EXAMPLE_DROP_DB);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_DROP_TABLE);
        return builder.toString();
    }

    private static String getExample() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append("or ");
        builder.append(EXAMPLE_CREATE_DB);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_CREATE_TABLE);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_INSERT);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_SELECT);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_UPDATE);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_DELETE);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_DROP_TABLE);
        builder.append("\n");
        builder.append("or ");
        builder.append(EXAMPLE_DROP_DB);
        return builder.toString();
    }
}
