package com.adventofcode.day10.part1;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int count(List<String> inputLines) {
        int[] diffs = new int[10];
        final List<Integer> inputArr = inputLines.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        inputArr.add(inputArr.get(inputArr.size() - 1) + 3);

        int prev = 0;
        for (int i = 0; i < inputArr.size(); i++) {
            int val = inputArr.get(i);
            int diff = val - prev;
            diffs[diff] = diffs[diff] + 1;
            prev = val;
        }

        return diffs[1] * diffs[3];
    }
}
