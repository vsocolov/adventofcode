package com.adventofcode.day8.part1;

import com.adventofcode.day8.Instruction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public long count(List<String> inputLines) {
        final Instruction[] instructions = getInstructions(inputLines);

        return doCount(0, 0, instructions, new HashSet<>());
    }

    private long doCount(int index, long count, Instruction[] instructions, Set<Integer> processed) {
        final var instruction = instructions[index];
        if (processed.contains(index))
            return count;

        processed.add(index);

        switch (instruction.getOperation()) {
            case acc:
                count += instruction.getValue() + doCount(index + 1, count, instructions, processed);
                break;
            case jmp:
                count += doCount(index + instruction.getValue(), count, instructions, processed);
                break;
            default:
                count += doCount(index + 1, count, instructions, processed);
        }

        return count;
    }

    private Instruction[] getInstructions(List<String> inputLines) {
        return inputLines.stream().map(Instruction::of).toArray(Instruction[]::new);
    }
}
