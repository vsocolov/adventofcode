package com.adventofcode.day9.part1;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public long findCypher(int preamble, List<String> inputLines) {
        final Long[] inputArr = inputLines.stream().map(Long::parseLong).toArray(Long[]::new);

        for (int i = preamble; i < inputArr.length; i++) {
            Long value = inputArr[i];
            if (!hasSum(i, preamble, inputArr)) {
                return value;
            }
        }

        return 0;
    }

    private boolean hasSum(int index, int preamble, Long[] inputArr) {
        final var copyArr = Arrays.copyOfRange(inputArr, index - preamble, index);
        Arrays.sort(copyArr);
        final var mainValue = inputArr[index];

        return doHasSum(0, copyArr.length - 1, copyArr, mainValue);
    }

    private boolean doHasSum(int start, int end, Long[] copyArr, Long mainValue) {
        if (start == end)
            return false;

        if (copyArr[start] + copyArr[end] > mainValue) {
            return doHasSum(start, end - 1, copyArr, mainValue);
        } else if (copyArr[start] + copyArr[end] < mainValue) {
            return doHasSum(start + 1, end, copyArr, mainValue);
        } else {
            return true; // sum found
        }
    }

    public long findSecondCypher(int preamble, List<String> inputLines) {
        final var cypher = findCypher(preamble, inputLines);
        final Long[] inputArr = inputLines.stream().map(Long::parseLong).toArray(Long[]::new);
        final var arrayRange = new ArrayRange(0, 1);
        if (hasPath(arrayRange, cypher, inputArr)) {
            System.out.println("Path has been found!");
            final var arrayResult = Arrays.copyOfRange(inputArr, arrayRange.startIndex, arrayRange.endIndex);
            final var max = Arrays.stream(arrayResult).mapToLong(v -> v).max();
            final var min = Arrays.stream(arrayResult).mapToLong(v -> v).min();

            return min.getAsLong() + max.getAsLong();
        }

        return 0;
    }

    private boolean hasPath(ArrayRange range, long cypher, Long[] inputArr) {
        final var rangeSum = rangeSum(range, inputArr);
        if (range.startIndex == range.endIndex)
            return false;

        if (rangeSum == cypher) {
            return true;
        } else if (rangeSum < cypher) {
            return hasPath(range.increment(), cypher, inputArr);
        } else {
            return hasPath(range.decrement(), cypher, inputArr);
        }
    }

    private long rangeSum(ArrayRange range, Long[] inputArr) {
        long sum = 0;
        for (int i = range.startIndex; i <= range.endIndex; i++) {
            sum += inputArr[i];
        }

        return sum;
    }

    private final static class ArrayRange {
        private int startIndex;
        private int endIndex;

        public ArrayRange(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public ArrayRange increment() {
            this.endIndex++;
            return this;
        }

        public ArrayRange decrement() {
            this.startIndex++;
            return this;
        }
    }
}
