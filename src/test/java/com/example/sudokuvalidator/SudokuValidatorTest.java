package com.example.sudokuvalidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SudokuValidatorTest {

    private SudokuValidator validator;
    private SudokuReader sudokuReader;

    @BeforeEach
    void setUp() {
        sudokuReader = new SudokuReaderImpl();
        validator = new SudokuValidator(sudokuReader);
    }

    @Test
    public void testValidSudoku() throws IOException {
        String validCsvPath = "src/main/resources/valid-sudoku.csv";
        String solutionFilePath = "src/main/resources/solution.csv";
        int[][] validFile = sudokuReader.readSudoku(validCsvPath);
        int[][] solution = sudokuReader.readSudoku(solutionFilePath);
        assertTrue(validator.isValidSudoku(validFile, solution));
    }

    @Test
    public void testInvalidSudoku() throws IOException {
        String invalidCsvPath = "src/main/resources/invalid-sudoku.csv";
        String solutionFilePath = "src/main/resources/solution.csv";
        int[][] invalidFile = sudokuReader.readSudoku(invalidCsvPath);
        int[][] solution = sudokuReader.readSudoku(solutionFilePath);
        assertFalse(validator.isValidSudoku(invalidFile, solution));
    }
}