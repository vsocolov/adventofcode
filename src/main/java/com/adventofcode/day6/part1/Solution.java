package com.adventofcode.day6.part1;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Solution {
    public long sum(List<String> inputLines) {
        final var sanitizeInput = sanitizeInput(inputLines);
        int grandSum = 0;

        for (UUID uuid : sanitizeInput.keySet()) {
            final var charCodes = sanitizeInput.get(uuid);
            grandSum += (int) Arrays.stream(charCodes).filter(charCode -> charCode == 1).count();
        }

        return grandSum;
    }

    private Map<UUID, int[]> sanitizeInput(List<String> inputLines) {
        final var result = new HashMap<UUID, int[]>();
        int[] charCodes = new int[127];
        for (String inputLine : inputLines) {
            for (char ch : inputLine.toCharArray()) {
                charCodes[ch] = 1;
            }

            if (StringUtils.isEmpty(inputLine)) {
                result.put(UUID.randomUUID(), charCodes);
                charCodes = new int[127];
            }
        }

        result.put(UUID.randomUUID(), charCodes);

        return result;
    }
}
