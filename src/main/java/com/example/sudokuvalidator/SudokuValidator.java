package com.example.sudokuvalidator;

import java.io.IOException;

public class SudokuValidator {
    private final SudokuReader sudokuReader;

    public SudokuValidator(SudokuReader sudokuReader) {
        this.sudokuReader = sudokuReader;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SudokuValidator valid-matrix.csv");
            System.exit(1);
        }

        SudokuReader sudokuReader = new SudokuReaderImpl();
        SudokuValidator sudokuValidator = new SudokuValidator(sudokuReader);
        String matrixFileName = args[0];
        String solutionFilePath = "src/main/resources/solution.csv";

        try {
            int[][] solution = sudokuReader.readSudoku(solutionFilePath);
            int[][] matrix = sudokuReader.readSudoku(matrixFileName);

            if (sudokuValidator.isValidSudoku(matrix, solution)) {
                System.out.println("true");
                System.exit(0);
            } else {
                System.out.println("false");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(2);
        }
    }

    public boolean isValidSudoku(int[][] matrix, int[][] solution) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != solution[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
