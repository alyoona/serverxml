package com.moc.jdbcclient.executors;

import com.moc.jdbcclient.queries.QueryCreateDataBase;
import com.moc.jdbcclient.xml.XMLUtil;

import javax.xml.XMLConstants;
import java.io.IOException;

public class CreateDataBaseExecutor implements Executor {

    private Object result;

    @Override
    public void process(Object object) {
        QueryCreateDataBase query = (QueryCreateDataBase) object;
        String entityName = query.getEntityName();
        XMLUtil.createDataBaseFolder(entityName);
        XMLUtil.generateDataBaseMetaDataXml(entityName);

    }

    @Override
    public Object getResult() {
        return null;
    }
}
