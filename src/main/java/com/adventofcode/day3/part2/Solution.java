package com.adventofcode.day3.part2;

import java.util.List;

import static com.adventofcode.day3.LineUtils.isTree;

public class Solution {
    public long count(final List<String> inputLines) {
        return doCalculate(1, 1, 1, 1, inputLines)
                * doCalculate(3, 1, 3, 1, inputLines)
                * doCalculate(5, 1, 5, 1, inputLines)
                * doCalculate(7, 1, 7, 1, inputLines)
                * doCalculate(1, 2, 1, 2, inputLines);
    }

    private long doCalculate(final int pointer,
                            final int line,
                            final int stepRight,
                            final int stepDown,
                            final List<String> inputLines) {
        if (line >= inputLines.size())
            return 0;

        final var isTree = isTree(pointer, inputLines.get(line));

        return isTree
                ? 1 + doCalculate(pointer + stepRight, line + stepDown, stepRight, stepDown, inputLines)
                : doCalculate(pointer + stepRight, line + stepDown, stepRight, stepDown, inputLines);
    }
}
