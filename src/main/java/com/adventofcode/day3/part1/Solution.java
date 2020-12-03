package com.adventofcode.day3.part1;

import java.util.List;

import static com.adventofcode.day3.LineUtils.isTree;

public class Solution {
    public int count(final List<String> inputLines) {
        return doCalculate(3, 1, inputLines);
    }

    private int doCalculate(final int pointer, final int line, final List<String> inputLines) {
        if (line >= inputLines.size())
            return 0;

        final var isTree = isTree(pointer, inputLines.get(line));

        return isTree
                ? 1 + doCalculate(pointer + 3, line + 1, inputLines)
                : doCalculate(pointer + 3, line + 1, inputLines);
    }
}
