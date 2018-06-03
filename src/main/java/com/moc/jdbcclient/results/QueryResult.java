package com.moc.jdbcclient.results;


import java.util.List;

public class QueryResult {

    private String resultMessage;

    private List<String> columns;

    private List<List<String>> content;

    public QueryResult() {
    }

    public QueryResult(List<String> columns, List<List<String>> content) {
        this.columns = columns;
        this.content = content;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<List<String>> getContent() {
        return content;
    }
}
