package com.adventofcode.day1.part2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // do calculation
        for (String inputLine : inputLines) {
            final var intValue = Integer.parseInt(inputLine);
            final int diff = 2020 - intValue;

            final var nestedValue = doCalculate(intValue, diff, hashes);
            if (nestedValue != -1)
                return intValue * nestedValue;
        }

        return -1;
    }

    private int doCalculate(final int ignoreVal, final int desiredYear, final Map<Integer, Integer> hashes) {
        for (Integer key : hashes.keySet()) {
            if (key != ignoreVal) {
                final int diff = desiredYear - key;
                if (diff == ignoreVal)
                    return -1;

                final var diffVal = hashes.get(diff);
                if (diffVal != null)
                    return key * diff;
            }
        }

        return -1;
    }
}
