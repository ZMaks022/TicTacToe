package com.example.tictactoe.bots;

import com.example.tictactoe.game.Cell;
import com.example.tictactoe.game.Game;

import java.util.Random;

/**
 * Represents an easy difficulty bot for the Tic-Tac-Toe game.
 * This bot makes its moves randomly on the game board.
 */
public class EasyBot implements Bot {
    /**
     * Generates a random move for the Tic-Tac-Toe game.
     * The method randomly selects a cell until it finds one that is free.
     *
     * @param game The current game state, used to check if the randomly selected cell is free.
     * @return The randomly selected free cell as the bot's next move.
     */
    @Override
    public Cell generate_step(Game game) {
        Random random = new Random();

        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }
        while (!game.is_free(new Cell(col, row)));

        return new Cell(col, row);
    }

}
