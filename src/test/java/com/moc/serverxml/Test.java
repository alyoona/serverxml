package com.moc.serverxml;

import com.moc.serverxml.connection.Connection;

public class Test {

    public static void main(String[] args) {
        Connection.setProperty("my-db");
        System.out.println(Connection.getDB());
    }
}
