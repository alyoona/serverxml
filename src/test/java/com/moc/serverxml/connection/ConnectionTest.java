package com.moc.serverxml.connection;

public class ConnectionTest {
    public static void main(String[] args) {
        Connection.setProperty("my-db");
        System.out.println(Connection.getDB());
    }
}
