package com.adventofcode.day10.part2;

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
        Assertions.assertEquals(8, underTest.count(inputLines));
    }

    @Test
    void testCountB() {
        // given
        final var inputLines = FileReaderUtils.readFile("day10b.txt");

        // then
        Assertions.assertEquals(19208, underTest.count(inputLines));
    }

    @Test
    void testCountC() {
        // given
        final var inputLines = FileReaderUtils.readFile("day10c.txt");

        // then
        Assertions.assertEquals(29, underTest.count(inputLines));
    }
}