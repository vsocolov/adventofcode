package com.adventofcode.day10.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCountA() {
        // given
        final var inputLines = FileReaderUtils.readFile("day10a.txt");

        // then
        Assertions.assertEquals(35, underTest.count(inputLines));
    }

    @Test
    void testCountB() {
        // given
        final var inputLines = FileReaderUtils.readFile("day10b.txt");

        // then
        Assertions.assertEquals(220, underTest.count(inputLines));
    }
}