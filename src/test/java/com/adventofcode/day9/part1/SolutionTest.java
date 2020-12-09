package com.adventofcode.day9.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testSum() {
        // given
        final var inputLines = FileReaderUtils.readFile("day9.txt");

        // then
        Assertions.assertEquals(127, underTest.findCypher(5, inputLines));
    }

    @Test
    void testSecondCypher() {
        // given
        final var inputLines = FileReaderUtils.readFile("day9.txt");

        // then
        Assertions.assertEquals(62, underTest.findSecondCypher(5, inputLines));
    }
}