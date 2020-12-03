package com.adventofcode.day2.part1;

import com.adventofcode.day2.InputData;

import java.util.HashMap;
import java.util.List;

public class Solution {

    public int count(List<String> inputLines) {
        int count = 0;
        for (String inputLine : inputLines) {
            if (isValid(inputLine))
                count++;
        }

        return count;
    }

    protected boolean isValid(final String input) {
        final InputData inputData = InputData.of(input);

        final var hashes = new HashMap<Character, Integer>();
        for (int i = 0; i < inputData.getPassword().length(); i++) {
            final char character = inputData.getPassword().charAt(i);
            hashes.merge(character, 1, Integer::sum);
        }

        final var charCount = hashes.get(inputData.getCharacter());

        return charCount != null && (charCount >= inputData.getMinVal() && charCount <= inputData.getMaxVal());
    }
}
