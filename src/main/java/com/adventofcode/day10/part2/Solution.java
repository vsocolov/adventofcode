package com.adventofcode.day10.part2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public long count(List<String> inputLines) {
        inputLines.add("0");
        final List<Integer> inputArr = inputLines.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        inputArr.add(inputArr.get(inputArr.size() - 1) + 3);
        Collections.sort(inputArr);

        int[] arr = new int[inputArr.get(inputArr.size() - 1) + 1];
        for (Integer integer : inputArr) {
            arr[integer] = 1;
        }


        long[] memo = new long[inputArr.size()];

        return doCount(inputArr.size() - 1, arr, memo);
    }

    private long doCount(int index, int[] arr, long[] memo) {
        if (index >= 0 && index <= 2)
            return computeDefaultValues(index, arr, memo);

        final var elem = getElem(arr, index);

        final Integer prev = getElem(arr, elem - 1);
        final Integer prevPrev = getElem(arr, elem - 2);
        final Integer prevPrevPrev = getElem(arr, elem - 3);

        if (memo[index - 1] == 0 && prev != null) {
            memo[index - 1] = doCount(index - 1, arr, memo);
        } else if (memo[index - 2] == 0 && prevPrev != null) {
            memo[index - 2] = doCount(index - 2, arr, memo);
        } else if (memo[index - 3] == 0 && prevPrevPrev != null) {
            memo[index - 3] = doCount(index - 3, arr, memo);
        }

        return memo[index - 1] + memo[index - 2] + memo[index - 3];
    }

    private Integer getElem(int[] arr, Integer elem) {
        try {
            if (arr[elem] == 1)
                return elem;
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    private long computeDefaultValues(int index, int[] arr, long[] memo) {
        if (index == 0) {
            memo[index] = 1;
            return memo[index];
        } else if (index == 1) {
            final var elem = getElem(arr, index);
            final Integer prev = getElem(arr, elem - 1);

            if (memo[index - 1] == 0 && prev != null) {
                memo[index - 1] = doCount(index - 1, arr, memo);
            }

            return memo[index - 1];
        } else {
            final var elem = getElem(arr, index);
            final Integer prev = getElem(arr, elem - 1);
            final Integer prevPrev = getElem(arr, elem - 2);

            if (memo[index - 1] == 0 && prev != null) {
                memo[index - 1] = doCount(index - 1, arr, memo);
            } else if (memo[index - 2] == 0 && prevPrev != null) {
                memo[index - 2] = doCount(index - 2, arr, memo);
            }

            return memo[index - 1] + memo[index - 2];
        }
    }
}