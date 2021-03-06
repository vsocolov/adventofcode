package com.adventofcode.day7.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testSum() {
        // given
        final var inputLines = FileReaderUtils.readFile("day7.txt");

        // then
        Assertions.assertEquals(4, underTest.count(inputLines));
    }
}