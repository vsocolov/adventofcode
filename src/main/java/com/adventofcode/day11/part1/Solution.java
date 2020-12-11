package com.adventofcode.day11.part1;

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
                if(matrix[i][j] != populatedMatrix[i][j])
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
                if (matrix[i][j] == 'L' && !isAdjacentOccupied(i, j, matrix))
                    matrixCopy[i][j] = '#';

                if (matrix[i][j] == '#' && isFourAdjacentOccupied(i, j, matrix))
                    matrixCopy[i][j] = 'L';
            }
        }

        return matrixCopy;
    }

    private boolean isFourAdjacentOccupied(int i, int j, char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int count = 0;
        if (i < rows - 1 && matrix[i + 1][j] == '#')
            count++;

        if (i > 0 && matrix[i - 1][j] == '#')
            count++;

        if (j < columns - 1 && matrix[i][j + 1] == '#')
            count++;

        if (j > 0 && matrix[i][j - 1] == '#')
            count++;

        if (i < rows - 1 && j < columns - 1 && matrix[i + 1][j + 1] == '#')
            count++;

        if (i > 0 && j < columns - 1 && matrix[i - 1][j + 1] == '#')
            count++;

        if (i < rows - 1 && j > 0 && matrix[i + 1][j - 1] == '#')
            count++;

        if (i > 0 && j > 0 && matrix[i - 1][j - 1] == '#')
            count++;

        return count >= 4;
    }

    private boolean isAdjacentOccupied(int i, int j, char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean isOccupied = false;
        if (i < rows - 1 && matrix[i + 1][j] == '#')
            isOccupied = true;

        if (i > 0 && matrix[i - 1][j] == '#')
            isOccupied = true;

        if (j < columns - 1 && matrix[i][j + 1] == '#')
            isOccupied = true;

        if (j > 0 && matrix[i][j - 1] == '#')
            isOccupied = true;

        if (i < rows - 1 && j < columns - 1 && matrix[i + 1][j + 1] == '#')
            isOccupied = true;

        if (i > 0 && j < columns - 1 && matrix[i - 1][j + 1] == '#')
            isOccupied = true;

        if (i < rows - 1 && j > 0 && matrix[i + 1][j - 1] == '#')
            isOccupied = true;

        if (i > 0 && j > 0 && matrix[i - 1][j - 1] == '#')
            isOccupied = true;

        return isOccupied;
    }

    private char[][] computeMatrix(List<String> inputLines) {
        int columns = inputLines.get(0).length();
        int rows = inputLines.size();
        final char[][] matrix = new char[rows][columns];

        for (int i = 0; i < inputLines.size(); i++) {
            String inputLine = inputLines.get(i);
            matrix[i] = inputLine.toCharArray();
        }

        return matrix;
    }
}
