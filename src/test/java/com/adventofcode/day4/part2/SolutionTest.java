package com.adventofcode.day4.part2;

import com.adventofcode.utils.FileReaderUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SolutionTest {
    private final Solution underTest = new Solution();

    @Test
    void testCalculate() {
        // given
        final var inputLines = FileReaderUtils.readFile("day4part2.txt");

        // then
        Assertions.assertEquals(4, underTest.count(inputLines));
    }

    @Test
    void hz() {
        String regex = "^(amb|blu|brn|gry|grn|hzl|oth)$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("blu");
        boolean isTrue = matcher.matches();
        Assertions.assertTrue(isTrue);
    }
}