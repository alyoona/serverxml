package com.moc.serverxml;

public class Test {

    public static void main(String[] args) {
        String sql = "CREATE DATABASE my_db";

        String[] arr = sql.split("CREATE DATABASE");
        for(String s : arr) {
            System.out.println(s);
        }

    }
}
