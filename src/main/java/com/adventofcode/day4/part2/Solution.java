package com.adventofcode.day4.part2;

import com.adventofcode.day4.PassportData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final boolean fieldsValid = validateFields(passport);
        return fieldsValid && (passport.getSize() == 8 || (passport.getSize() == 7 && StringUtils.isEmpty(passport.getCid())));
    }

    private boolean validateFields(final PassportData passport) {
        boolean isValid = true;

        if (!isValidByr(passport))
            return false;

        if (!isValidIyr(passport))
            return false;

        if (!isValidEyr(passport))
            return false;

        if (!isValidHcl(passport))
            return false;

        if (!isValidEcl(passport))
            return false;

        if (!isValidPid(passport))
            return false;

        if (!isValidHgt(passport))
            return false;

        return isValid;
    }

    private boolean isValidHgt(PassportData passport) {
        try {
            if (passport.getHgt().endsWith("cm")) {
                final var hgt = Integer.parseInt(passport.getHgt().replace("cm", StringUtils.EMPTY));
                return hgt >= 150 && hgt <= 193;
            } else if (passport.getHgt().endsWith("in")) {
                final var hgt = Integer.parseInt(passport.getHgt().replace("in", StringUtils.EMPTY));
                return hgt >= 59 && hgt <= 76;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidPid(PassportData passport) {
        if(StringUtils.isEmpty(passport.getPid()))
            return false;

        final Pattern pattern = Pattern.compile("\\d{9}");
        final Matcher matcher = pattern.matcher(passport.getPid());
        return matcher.matches();
    }

    private boolean isValidEcl(PassportData passport) {
        if(StringUtils.isEmpty(passport.getEcl()))
            return false;

        final Pattern pattern = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
        final Matcher matcher = pattern.matcher(passport.getEcl());
        return matcher.matches();
    }

    private boolean isValidHcl(PassportData passport) {
        if(StringUtils.isEmpty(passport.getHcl()))
            return false;

        final Pattern pattern = Pattern.compile("^#([a-fA-F0-9]{6})$");
        final Matcher matcher = pattern.matcher(passport.getHcl());
        return matcher.matches();
    }

    private boolean isValidEyr(PassportData passport) {
        try {
            final int eyr = Integer.parseInt(passport.getEyr());
            return eyr >= 2020 && eyr <= 2030;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidIyr(PassportData passport) {
        try {
            final int iyr = Integer.parseInt(passport.getIyr());
            return iyr >= 2010 && iyr <= 2020;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidByr(PassportData passport) {
        try {
            final int byr = Integer.parseInt(passport.getByr());
            return byr >= 1920 && byr <= 2002;
        } catch (Exception e) {
            return false;
        }
    }
}
