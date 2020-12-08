package com.adventofcode.day8;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Instruction {
    private InstructionOperation operation;
    private int value;

    public Instruction(InstructionOperation operation, int value) {
        this.operation = operation;
        this.value = value;
    }

    public static Instruction of(final String line) {
        final var strings = line.split(" ");
        return new Instruction(InstructionOperation.valueOf(strings[0]), Integer.parseInt(strings[1]));
    }

    public InstructionOperation getOperation() {
        return operation;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        return new EqualsBuilder().append(value, that.value).append(operation, that.operation).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(operation).append(value).toHashCode();
    }
}
