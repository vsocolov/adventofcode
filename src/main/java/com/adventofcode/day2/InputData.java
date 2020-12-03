package com.adventofcode.day2;

import static com.adventofcode.day2.InputData.InputDataBuilder.anInputData;

public class InputData {
    private int minVal;
    private int maxVal;
    private char character;
    private String password;

    public int getMinVal() {
        return minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }

    public char getCharacter() {
        return character;
    }

    public String getPassword() {
        return password;
    }

    public static InputData of(final String inputLine) {
        final String[] strings = inputLine.replaceAll(":", "").split(" ");
        final var ranges = strings[0].split("-");

        return anInputData()
                .withMinVal(Integer.parseInt(ranges[0]))
                .withMaxVal(Integer.parseInt(ranges[1]))
                .withCharacter(strings[1].charAt(0))
                .withPassword(strings[2])
                .build();
    }

    public static final class InputDataBuilder {
        private int minVal;
        private int maxVal;
        private char character;
        private String password;

        private InputDataBuilder() {
        }

        public static InputDataBuilder anInputData() {
            return new InputDataBuilder();
        }

        public InputDataBuilder withMinVal(int minVal) {
            this.minVal = minVal;
            return this;
        }

        public InputDataBuilder withMaxVal(int maxVal) {
            this.maxVal = maxVal;
            return this;
        }

        public InputDataBuilder withCharacter(char character) {
            this.character = character;
            return this;
        }

        public InputDataBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public InputData build() {
            InputData inputData = new InputData();
            inputData.character = this.character;
            inputData.minVal = this.minVal;
            inputData.maxVal = this.maxVal;
            inputData.password = this.password;
            return inputData;
        }
    }
}
