package com.adventofcode.day3.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCalculate() {
        // given
        final var inputLines = FileReaderUtils.readFile("day3.txt");

        // then
        Assertions.assertEquals(7, underTest.count(inputLines));
    }

}