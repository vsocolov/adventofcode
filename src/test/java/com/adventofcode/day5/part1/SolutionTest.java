package com.adventofcode.day5.part1;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCalculate() {
        // given
        final var inputLines = FileReaderUtils.readFile("day5.txt");

        // then
        Assertions.assertEquals(820, underTest.calculate(inputLines));
    }

    @ParameterizedTest
    @MethodSource("provideStrings")
    void testGetSeatId(final String input, final long expectedSeatId) {
        Assertions.assertEquals(expectedSeatId, underTest.getSeatId(input));
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
                Arguments.of("FBFBBFFRLR", 357),
                Arguments.of("BFFFBBFRRR", 567),
                Arguments.of("FFFBBBFRRR", 119),
                Arguments.of("BBFFBBFRLL", 820)
        );
    }
}