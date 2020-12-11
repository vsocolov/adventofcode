package com.adventofcode.day11.part1;

import com.adventofcode.utils.FileReaderUtils;

public class Main {
    private final static String INPUT_DATA = "day11.txt";

    public static void main(final String[] args) {
        final var solution = new Solution();

        final var inputLines = FileReaderUtils.readFile(INPUT_DATA);

        System.out.println(solution.count(inputLines));
    }
}
