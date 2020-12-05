package com.adventofcode.day5.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long calculate(List<String> inputLines) {
        long max = Long.MIN_VALUE;

        for (String inputLine : inputLines) {
            final long seatId = getSeatId(inputLine);
            if (seatId > max)
                max = seatId;
        }

        return max;
    }

    protected long getSeatId(String inputLine) {
        final int[] rows = populateRowsCols(128);
        final int[] cols = populateRowsCols(8);

        final char[] rowChar = new char[7];
        final char[] colChar = new char[3];
        final char[] inputAsChars = inputLine.toCharArray();
        int colIndex = 0;
        for (int i = 0; i < inputAsChars.length; i++) {
            char c = inputAsChars[i];
            if (i < 7)
                rowChar[i] = c;
            if (i >= 7) {
                colChar[colIndex] = c;
                colIndex++;
            }
        }

        final int rowValue = getRow(inputAsChars, rows);
        final int colValue = getCol(inputAsChars, cols);

        return rowValue * 8L + colValue;
    }

    private int getRow(char[] chars, int[] rows) {
        int left = 0;
        int right = rows.length - 1;
        for (char aChar : chars) {
            if (aChar == 'F') {
                right = (int) Math.round(((left + right) / 2.0) - 0.1);
            } else if (aChar == 'B') {
                left = (int) Math.round(((left + right) / 2.0) + 0.1);
            }
        }

        return left;
    }

    private int getCol(char[] chars, int[] cols) {
        int left = 0;
        int right = cols.length - 1;
        for (char aChar : chars) {
            if (aChar == 'R') {
                left = (int) Math.round(((left + right) / 2.0) + 0.1);
            } else if (aChar == 'L') {
                right = (int) Math.round(((left + right) / 2.0) - 0.1);
            }
        }

        return right;
    }

    private int[] populateRowsCols(final int size) {
        final int[] buffer = new int[size];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i;
        }

        return buffer;
    }

    public long findMissingSeat(List<String> inputLines) {
        long mySeat = Integer.MIN_VALUE;

        Map<Long, Long> hashes = new HashMap<>();

        for (String inputLine : inputLines) {
            final var seatId = getSeatId(inputLine);
            hashes.put(seatId, seatId);
        }

        for (long i = 0; i <= 128 * 7; i++) {
            final var hashValue = hashes.get(i);
            if (hashValue == null && hashes.get(i + 1) != null && hashes.get(i - 1) != null)
                mySeat = i;
        }

        return mySeat;
    }
}
