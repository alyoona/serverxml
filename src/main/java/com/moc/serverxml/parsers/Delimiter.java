package com.moc.serverxml.parsers;

import java.util.Arrays;
import java.util.List;

public class Delimiter {

    public static String getDelimiter(String... args) {
        List<String> list = Arrays.asList(args);
        return String.join(" ", list);
    }
}
