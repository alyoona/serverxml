package com.moc.serverxml;

import com.moc.serverxml.executors.QueryExecutor;
import com.moc.serverxml.queries.Parser;
import com.moc.serverxml.queries.Query;
import com.moc.serverxml.results.QueryResult;


public class Server {

    public void start() {
        String sql = "CREATE DATABASE my_DB;";
        Query query = Parser.parse(sql);
        QueryExecutor queryExecutor = new QueryExecutor();
        queryExecutor.process(query);
        QueryResult queryResult = queryExecutor.getResult();
        String result = queryResult.getResultMessage();
        System.out.println(result);
    }
}
