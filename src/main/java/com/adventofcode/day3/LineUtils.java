package com.adventofcode.day3;

public final class LineUtils {
    public static boolean isTree(final int pointer, final String line) {
        final int index = calculateIndex(pointer, line);
        final char character = line.charAt(index);

        return character == '#';
    }

    private static int calculateIndex(final int pointer, final String line) {
        return pointer < line.length()
                ? pointer
                : Math.abs(calculateIndex(pointer - line.length(), line));
    }
}
