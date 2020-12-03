package com.adventofcode.day2.part2;

import com.adventofcode.day2.InputData;

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

        final var chars = inputData.getPassword().toCharArray();
        int count = 0;
        if (chars[inputData.getMinVal() - 1] == inputData.getCharacter())
            count++;

        if (chars[inputData.getMaxVal() - 1] == inputData.getCharacter())
            count++;

        return count == 1;
    }
}
