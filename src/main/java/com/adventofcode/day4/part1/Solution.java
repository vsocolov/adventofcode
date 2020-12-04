package com.adventofcode.day4.part1;

import com.adventofcode.day4.PassportData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.adventofcode.day4.PassportUtils.sanitizeInput;

public class Solution {
    public int count(List<String> inputLines) {
        final List<String> sanitizedStrings = sanitizeInput(inputLines);
        final List<PassportData> passports = buildPassports(sanitizedStrings);

        int count = 0;
        for (final PassportData passport : passports) {
            if (isValid(passport))
                count++;
        }

        return count;
    }

    private List<PassportData> buildPassports(final List<String> sanitizedStrings) {
        final var passports = new ArrayList<PassportData>();
        for (final String sanitizedString : sanitizedStrings) {
            passports.add(PassportData.of(sanitizedString));
        }

        return passports;
    }

    private boolean isValid(final PassportData passport) {
        return passport.getSize() == 8 || (passport.getSize() == 7 && StringUtils.isEmpty(passport.getCid()));
    }
}
