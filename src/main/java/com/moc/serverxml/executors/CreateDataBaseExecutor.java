package com.moc.serverxml.executors;

import com.moc.serverxml.queries.QueryCreateDataBase;

public class CreateDataBaseExecutor implements Executor {

    private Object result;

    @Override
    public void process(Object object) {
        QueryCreateDataBase query = (QueryCreateDataBase) object;
        String entityType = query.getEntityType();
        String entityName = query.getEntityName();

    }

    @Override
    public Object getResult() {
        return null;
    }
}
