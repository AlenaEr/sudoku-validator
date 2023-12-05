package com.example.sudokuvalidator;

import java.io.IOException;

public interface SudokuReader {
    int[][] readSudoku(String fileName) throws IOException;
}
