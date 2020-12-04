package com.adventofcode.day4.part1;


import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCalculate() {
        // given
        final var inputLines = FileReaderUtils.readFile("day4.txt");

        // then
        Assertions.assertEquals(2, underTest.count(inputLines));
    }
}