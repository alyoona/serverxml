package com.moc.serverxml.executors;


import com.moc.serverxml.queries.Query;
import com.moc.serverxml.results.QueryResult;
import com.moc.serverxml.xml.XmlMetadata;

public class QueryExecutor {

   private QueryResult queryResult;

    public void process(Query query) {

        XmlMetadata xmlMetadata = new XmlMetadata(query);
        xmlMetadata.generate();

        queryResult = null;
    }

    public QueryResult getResult(){
        return queryResult;
    }
}
