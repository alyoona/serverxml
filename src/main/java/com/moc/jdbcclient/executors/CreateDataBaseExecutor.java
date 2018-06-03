package com.moc.jdbcclient.executors;

import com.moc.jdbcclient.queries.QueryCreateDataBase;
import com.moc.jdbcclient.xml.XMLUtil;

public class CreateDataBaseExecutor  {

    public static String process(QueryCreateDataBase queryCreate) {
        String entityName = queryCreate.getEntityName();
        XMLUtil.createDataBaseFolder(entityName);
        XMLUtil.generateDataBaseMetaDataXml(entityName);
        return "DataBase " + entityName + " was successfully created";
    }

}
