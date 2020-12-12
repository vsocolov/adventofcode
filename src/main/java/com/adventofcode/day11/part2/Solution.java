package com.adventofcode.day11.part2;

import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

public class Solution {
    public int count(List<String> inputLines) {
        char[][] matrix = computeMatrix(inputLines);
        char[][] populatedMatrix;
        boolean matrixEqual;

        do {
            populatedMatrix = doGeneration(matrix);
            matrixEqual = matrixEquals(matrix, populatedMatrix);
            matrix = populatedMatrix;
        } while (!matrixEqual);

        return countSeats(matrix);
    }

    private boolean matrixEquals(char[][] matrix, char[][] populatedMatrix) {
        int length = matrix.length;
        int height = matrix[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] != populatedMatrix[i][j])
                    return false;
            }
        }

        return true;
    }

    private int countSeats(char[][] matrix) {
        int length = matrix.length;
        int height = matrix[0].length;

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == '#')
                    count++;
            }
        }

        return count;
    }

    private char[][] doGeneration(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        char[][] matrixCopy = SerializationUtils.clone(matrix);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != '.') {
                    final var adjacentResult = isVisibleAdjacentOccupied(i, j, matrix);
                    if (matrix[i][j] == 'L' && !adjacentResult.isOccupied())
                        matrixCopy[i][j] = '#';

                    if (matrix[i][j] == '#' && adjacentResult.is5Occupied())
                        matrixCopy[i][j] = 'L';
                }
            }
        }

        return matrixCopy;
    }

    public AdjacentResult isVisibleAdjacentOccupied(int i, int j, char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean isOccupied = false;
        int count = 0;

        // horizontal to left
        if (j > 0) {
            for (int n = j - 1; n >= 0; n--) {
                if (matrix[i][n] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[i][n] == 'L') {
                    break;
                }
            }
        }

        // horizontal to right
        if (j < columns - 1) {
            for (int n = j + 1; n < columns; n++) {
                if (matrix[i][n] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[i][n] == 'L') {
                    break;
                }
            }
        }

        // vertical to top
        if (i > 0) {
            for (int n = i - 1; n >= 0; n--) {
                if (matrix[n][j] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][j] == 'L') {
                    break;
                }
            }
        }

        // vertical to bottom
        if (i < rows - 1) {
            for (int n = i + 1; n < rows; n++) {
                if (matrix[n][j] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][j] == 'L') {
                    break;
                }
            }
        }

        // main diagonal to left
        if (i > 0 && j > 0) {
            for (int n = i - 1, m = j - 1; n >= 0 && m >= 0; n--, m--) {
                if (matrix[n][m] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][m] == 'L') {
                    break;
                }
            }
        }

        // main diagonal to right
        if (i < rows - 1 && j < columns - 1) {
            for (int n = i + 1, m = j + 1; n < rows && m < columns; n++, m++) {
                if (matrix[n][m] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][m] == 'L') {
                    break;
                }
            }
        }

        // second diagonal to right
        if (i > 0 && j < columns - 1) {
            for (int n = i - 1, m = j + 1; n >= 0 && m < columns; n--, m++) {
                if (matrix[n][m] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][m] == 'L') {
                    break;
                }
            }
        }

        // second diagonal to left
        if (i < rows - 1 && j > 0) {
            for (int n = i + 1, m = j - 1; n < rows && m >= 0; n++, m--) {
                if (matrix[n][m] == '#') {
                    isOccupied = true;
                    count++;
                    break;
                } else if (matrix[n][m] == 'L') {
                    break;
                }
            }
        }

        return new AdjacentResult(isOccupied, count >= 5);
    }

    protected char[][] computeMatrix(List<String> inputLines) {
        int columns = inputLines.get(0).length();
        int rows = inputLines.size();
        final char[][] matrix = new char[rows][columns];

        for (int i = 0; i < inputLines.size(); i++) {
            String inputLine = inputLines.get(i);
            matrix[i] = inputLine.toCharArray();
        }

        return matrix;
    }

    public final static class AdjacentResult {
        private final boolean isOccupied;
        private final boolean is5Occupied;

        public AdjacentResult(boolean isOccupied, boolean is5Occupied) {
            this.isOccupied = isOccupied;
            this.is5Occupied = is5Occupied;
        }

        public boolean isOccupied() {
            return isOccupied;
        }

        public boolean is5Occupied() {
            return is5Occupied;
        }
    }
}
