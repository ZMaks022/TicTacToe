package com.example.tictactoe.game;

public class Cell {
    private final int column;
    private final int row;

    public Cell(int column, int row) {
        if (column < 0 || column > 2 || row < 0 || row > 2) {
            throw new IllegalArgumentException("Column and row must be between 0 and 2");
        }
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
