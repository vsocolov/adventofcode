package com.adventofcode.day4;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class PassportUtils {
    public static final String BLANK_STRING = " ";

    public static List<String> sanitizeInput(final List<String> inputLines) {
        final var sanitizedLines = new ArrayList<String>();

        var buffer = new StringBuilder();
        for (int i = 0; i < inputLines.size(); i++) {
            final String line = inputLines.get(i);
            if (i < inputLines.size() - 1) {
                final var nextLine = inputLines.get(i + 1);
                buffer.append(BLANK_STRING).append(line);
                if (StringUtils.isEmpty(nextLine)) {
                    sanitizedLines.add(buffer.toString().trim());
                    buffer = new StringBuilder();
                }
            } else {
                buffer.append(BLANK_STRING).append(line);
                sanitizedLines.add(buffer.toString().trim());
            }
        }

        return sanitizedLines;
    }
}
