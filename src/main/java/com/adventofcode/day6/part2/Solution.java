package com.adventofcode.day6.part2;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Solution {
    public long sum(List<String> inputLines) {
        final var sanitizeInput = sanitizeInput(inputLines);
        int grandSum = 0;

        for (UUID uuid : sanitizeInput.keySet()) {
            final var data = sanitizeInput.get(uuid);
            for (int sum : data.charCodes) {
                if(sum == data.peopleNr)
                    grandSum++;
            }
        }
        
        return grandSum;
    }

    private Map<UUID, Tuple> sanitizeInput(List<String> inputLines) {
        final var result = new HashMap<UUID, Tuple>();
        int[] charCodes = new int[127];
        int peopleNr = 0;
        for (String inputLine : inputLines) {
            peopleNr++;
            for (char ch : inputLine.toCharArray()) {
                charCodes[ch] = charCodes[ch] + 1;
            }

            if (StringUtils.isEmpty(inputLine)) {
                peopleNr--;
                result.put(UUID.randomUUID(), new Tuple(peopleNr, charCodes));
                charCodes = new int[127];
                peopleNr = 0;
            }
        }

        result.put(UUID.randomUUID(), new Tuple(peopleNr, charCodes));

        return result;
    }

    private static final class Tuple {
        private int peopleNr;
        private int[] charCodes;

        public Tuple(int peopleNr, int[] charCodes) {
            this.peopleNr = peopleNr;
            this.charCodes = charCodes;
        }
    }

}
