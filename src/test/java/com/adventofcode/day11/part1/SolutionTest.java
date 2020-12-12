package com.adventofcode.day11.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCount() {
        // given
        final var inputLines = FileReaderUtils.readFile("day11/day11.txt");

        // then
        Assertions.assertEquals(37, underTest.count(inputLines));
    }
}