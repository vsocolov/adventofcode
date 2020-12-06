package com.adventofcode.day6.part2;

import com.adventofcode.utils.FileReaderUtils;

public class Main {
    private final static String INPUT_DATA = "day6.txt";

    public static void main(final String[] args) {
        final var solution = new Solution();

        final var inputLines = FileReaderUtils.readFile(INPUT_DATA);

        System.out.println(solution.sum(inputLines));
    }
}
