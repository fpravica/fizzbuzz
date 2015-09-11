package com.prottone.fizzbuzz.util;

public final class SimpleUtils {

    private SimpleUtils() { }

    public static String capitalize (final String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
