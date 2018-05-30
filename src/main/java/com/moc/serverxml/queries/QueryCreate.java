package com.moc.serverxml.queries;

public class QueryCreate extends Query {


    private String entityType; // Table or DataBase
    private String entityName;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryCreate{");
        sb.append("entityType='").append(entityType).append('\'');
        sb.append(", entityName='").append(entityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
