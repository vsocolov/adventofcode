package com.adventofcode.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public final class FileReaderUtils {

    public static List<String> readFile(final String fileName) {

        final var classLoader = FileReaderUtils.class.getClassLoader();
        final var file = new File(classLoader.getResource(fileName).getFile());
        try {
            return FileUtils.readLines(file, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read input file.", e);
        }
    }
}
