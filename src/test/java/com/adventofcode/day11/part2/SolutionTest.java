package com.adventofcode.day11.part2;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCount() {
        // given
        final var inputLines = FileReaderUtils.readFile("day11/day11.txt");

        // then
        Assertions.assertEquals(26, underTest.count(inputLines));
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void testVisibleAdjacentA(String inputPath, int i, int j, boolean expected) {
        // given
        final var matrix = underTest.computeMatrix(FileReaderUtils.readFile(inputPath));

        //then
        Assertions.assertEquals(expected, underTest.isVisibleAdjacentOccupied(i, j, matrix).isOccupied());
    }

    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of("day11/day11a.txt", 4, 3, true),
                Arguments.of("day11/day11b.txt", 1, 1, false),
                Arguments.of("day11/day11c.txt", 3, 3, false),
                Arguments.of("day11/day11d.txt", 2, 3, true)
        );
    }
}