package com.moc.jdbcclient.exceprions;

import com.moc.jdbcclient.exceptions.InvalidSyntaxException;
import com.moc.jdbcclient.exceptions.Message;
import org.junit.Test;


public class MessageTest {

    @Test(expected = InvalidSyntaxException.class)
    public void testMessage() {
        throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE);
    }
}
