package com.moc.jdbcclient.executors;

import com.moc.jdbcclient.enums.Operator;
import com.moc.jdbcclient.queries.Query;
import com.moc.jdbcclient.queries.QueryCreateDataBase;

public class QueryExecutor implements Executor {

    private Object result;

    @Override
    public Object getResult() {
        return result;
    }

    @Override
    public void process(Object object) {
        Query query = (Query) object;
        if ((Operator.CREATE.name()).equals(query.getOperatorType())) {
            QueryCreateDataBase queryCreate = (QueryCreateDataBase) query;
            CreateDataBaseExecutor createExecutor = new CreateDataBaseExecutor();
            createExecutor.process(queryCreate);
            result = createExecutor.getResult();
        } else if ((Operator.INSERT.name()).equals(query.getOperatorType())) {
            //todo
        } else if ((Operator.SELECT.name()).equals(query.getOperatorType())) {
            //todo
        } else if ((Operator.UPDATE.name()).equals(query.getOperatorType())) {
            //todo
        } else if ((Operator.DELETE.name()).equals(query.getOperatorType())) {
            //todo
        } else if ((Operator.DROP.name()).equals(query.getOperatorType())) {
            //todo
        }
    }
}