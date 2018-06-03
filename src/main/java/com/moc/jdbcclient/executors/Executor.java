package com.moc.jdbcclient.executors;

public interface Executor {

    void process(Object object);

    Object getResult();
}

