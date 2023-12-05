package com.example.sudokuvalidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuReaderImpl implements SudokuReader {

    @Override
    public int[][] readSudoku(String fileName) throws IOException {
        int[][] sudoku = new int[9][9];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < 9; i++) {
                String[] values = reader.readLine().split(",");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(values[j]);
                }
            }
        }
        return sudoku;
    }
}

