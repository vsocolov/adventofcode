package com.adventofcode.day1.part1;

import com.adventofcode.utils.FileReaderUtils;

public class Main {
    private final static String INPUT_DATA = "day1.txt";

    public static void main(final String[] args) {
        final var inputLines = FileReaderUtils.readFile(INPUT_DATA);

        final Solution solution = new Solution(inputLines);

        System.out.println(solution.calculate());
    }

}
