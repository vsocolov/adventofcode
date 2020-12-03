package com.adventofcode.day2.part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {
    private final Solution underTest = new Solution();

    @ParameterizedTest
    @MethodSource("provideStrings")
    void testIsValid(final String input, final boolean expected) {
        Assertions.assertEquals(expected, underTest.isValid(input));
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
                Arguments.of("1-3 a: abcde", true),
                Arguments.of("1-3 b: cdefg", false),
                Arguments.of("2-9 c: ccccccccc", true)
        );
    }
}