package com.adventofcode.day8.part2;

import com.adventofcode.day8.Instruction;
import com.adventofcode.day8.InstructionOperation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import static com.adventofcode.day8.InstructionOperation.jmp;
import static com.adventofcode.day8.InstructionOperation.nop;

public class Solution {
    public long count(List<String> inputLines) {
        final Instruction[] instructions = getInstructions(inputLines);

        for (int i = 0; i < instructions.length; i++) {
            final Instruction instruction = instructions[i];
            if (instruction.getOperation() == jmp) {
                if (pathFound(instructions, i, instruction, nop, jmp))
                    return doCount(0, 0, instructions, new HashSet<>());
            } else if (instruction.getOperation() == nop) {
                if (pathFound(instructions, i, instruction, jmp, nop))
                    return doCount(0, 0, instructions, new HashSet<>());
            }
        }

        return -1;
    }

    private boolean pathFound(Instruction[] instructions, int i, Instruction instruction, InstructionOperation swapOperation, InstructionOperation oldOperation) {
        if (!findPath(0, instructions, new Stack<>())) {
            instructions[i] = new Instruction(swapOperation, instruction.getValue());
            if (findPath(0, instructions, new Stack<>())) {
                return true;
            } else {
                instructions[i] = new Instruction(oldOperation, instruction.getValue());
            }
        } else {
            return true;
        }
        return false;
    }

    private boolean findPath(int index, Instruction[] instructions, Stack<Integer> processed) {
        if (index > instructions.length - 1)
            return true;

        if (processed.contains(index))
            return false;

        processed.push(index);

        var instruction = instructions[index];

        if (instruction.getOperation() == jmp)
            return findPath(index + instruction.getValue(), instructions, processed);

        return findPath(index + 1, instructions, processed);
    }

    private long doCount(int index, long count, Instruction[] instructions, Set<Integer> processed) {
        if (index > instructions.length - 1)
            return count;

        final var instruction = instructions[index];

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
