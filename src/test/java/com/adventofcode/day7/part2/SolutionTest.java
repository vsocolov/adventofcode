package com.adventofcode.day7.part2;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testSum1() {
        // given
        final var inputLines = FileReaderUtils.readFile("day7part2a.txt");

        // then
        Assertions.assertEquals(126, underTest.count(inputLines));
    }

    @Test
    void testSum2() {
        // given
        final var inputLines = FileReaderUtils.readFile("day7part2b.txt");

        // then
        Assertions.assertEquals(32, underTest.count(inputLines));
    }
}