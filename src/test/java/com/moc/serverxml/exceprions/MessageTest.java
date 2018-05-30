package com.moc.serverxml.exceprions;

import com.moc.serverxml.exceptions.InvalidSyntaxException;
import com.moc.serverxml.exceptions.Message;
import org.junit.Test;

public class MessageTest {

    @Test(expected = InvalidSyntaxException.class)
    public void testMessage() {
        throw new InvalidSyntaxException("Supported next SQL syntax: " + Message.EXAMPLE);
    }
}
