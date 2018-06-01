package com.moc.serverxml.queries;

public abstract class Query {

    private String operatorType;
    private String entityType; // Table or DataBase
    private String entityName;

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }


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
