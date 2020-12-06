package com.adventofcode.day6.part2;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testSum() {
        // given
        final var inputLines = FileReaderUtils.readFile("day6.txt");

        // then
        Assertions.assertEquals(6, underTest.sum(inputLines));
    }
}