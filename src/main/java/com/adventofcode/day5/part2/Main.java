package com.adventofcode.day5.part2;

import com.adventofcode.day5.part1.Solution;
import com.adventofcode.utils.FileReaderUtils;

public class Main {
    private final static String INPUT_DATA = "day5.txt";

    public static void main(final String[] args) {
        final var solution = new Solution();

        final var inputLines = FileReaderUtils.readFile(INPUT_DATA);

        System.out.println(solution.findMissingSeat(inputLines));
    }
}
