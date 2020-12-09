package com.adventofcode.day9.part2;

import com.adventofcode.day9.part1.Solution;
import com.adventofcode.utils.FileReaderUtils;

public class Main {
    private final static String INPUT_DATA = "day9.txt";

    public static void main(final String[] args) {
        final var solution = new Solution();

        final var inputLines = FileReaderUtils.readFile(INPUT_DATA);

        System.out.println(solution.findSecondCypher(25, inputLines));
    }
}
