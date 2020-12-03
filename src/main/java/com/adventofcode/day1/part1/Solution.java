package com.adventofcode.day1.part1;

import java.util.HashMap;
import java.util.List;

public class Solution {
    private final List<String> inputLines;

    public Solution(List<String> inputLines) {
        this.inputLines = inputLines;
    }

    public int calculate() {
        final var hashes = new HashMap<Integer, Integer>();

        // build hashes
        for (String inputLine : inputLines) {
            final var intValue = Integer.valueOf(inputLine);
            hashes.merge(intValue, 1, Integer::sum);
        }

        // calculate result
        for (String inputLine : inputLines) {
            final var intValue = Integer.valueOf(inputLine);
            final int diff = 2020 - intValue;
            final var hashValue = hashes.get(diff);
            if (hashValue != null)
                return intValue * diff;
        }


        return -1;
    }
}
