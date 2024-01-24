package com.example.tictactoe.bots;

import com.example.tictactoe.game.Cell;
import com.example.tictactoe.game.Game;
import com.example.tictactoe.game.Player;

import java.util.Random;

/**
 * This is a bot of medium complexity for the game “Tic Tac Toe”.
 * This bot makes moves on the playing field randomly.
 * But if he sees that somewhere there are already 2 of his cells and he can win,
 * then he chooses it. If the enemy already has 2 cells, he will try to prevent him from winning.
 */
public class MiddleBot implements Bot {

    /**
     * Generates the next move for the bot in the Tic-Tac-Toe game with a middle-level difficulty strategy.
     * The strategy includes checking for a winning move, blocking the opponent's winning move, or making a random move.
     *
     * @param game The current state of the game, providing the necessary context for the bot to make a decision.
     * @return The next move as a Cell object. This could be a winning move, a blocking move, or a random move.
     */
    @Override
    public Cell generate_step(Game game) {
        // checking the possibility of victory
        Cell result = checkFieldByPlayer(game, Player.PLAYER_TWO);
        if (result != null) {
            return result;
        }

        // we don’t let the enemy win if he can already
        result = checkFieldByPlayer(game, Player.PLAYER_ONE);
        if (result != null)
            return result;

        // otherwise we choose randomly
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }
        while (!game.is_free(new Cell(col, row)));

        return new Cell(col, row);
    }

    /**
     * Checks the game field for potential winning or blocking moves for the specified player.
     *
     * @param game The current game state.
     * @param player The player to check for winning or blocking moves (PLAYER_ONE or PLAYER_TWO).
     * @return The cell to make the next move if a winning or blocking move is found; otherwise, null.
     */
    private Cell checkFieldByPlayer(Game game, Player player) {
        // check two in horizontal line
        for (int i = 0; i < 3; i++) {
            Cell result = checkLine(game, true, i, player);
            if (result != null)
                return result;
        }

        // check two in vertical line
        for (int i = 0; i < 3; i++) {
            Cell result = checkLine(game, false, i, player);
            if (result != null)
                return result;
        }

        // check left to right diagonal
        Cell result = checkDiagonal(game, true, player);
        if (result != null)
            return result;

        // check right to left diagonal
        result = checkDiagonal(game, false, player);
        if (result != null)
            return result;

        return null;
    }

    /**
     * Checks a specific line (horizontal or vertical) on the game field for a winning or blocking move.
     *
     * @param game The current game state.
     * @param horizontal True if checking a horizontal line, false for a vertical line.
     * @param row The row or column index to check.
     * @param player The player to check for. (PLAYER_ONE or PLAYER_TWO)
     * @return The cell to make the next move if a winning or blocking move is found; otherwise, null.
     */
    private Cell checkLine(Game game, boolean horizontal, int row, Player player) {
        int playerCounter = 0;
        Cell result = null;

        for (int col = 0; col < 3; col++) {
            Cell forCheck = new Cell(col, row);
            if (!horizontal)
                forCheck = new Cell(row, col);

            if (game.whose_cell(forCheck) == player)
                playerCounter++;
            if (game.is_free(forCheck))
                result = forCheck;
        }

        if (playerCounter == 2)
            return result;
        return null;
    }

    /**
     * Checks diagonals on the game field for a winning or blocking move for the specified player.
     *
     * @param game The current game state.
     * @param left True for left-to-right diagonal, false for right-to-left diagonal.
     * @param player The player to check for.
     * @return The cell to make the next move if a winning or blocking move is found; otherwise, null.
     */
    private Cell checkDiagonal(Game game, boolean left, Player player) {
        int playerCounter = 0;
        Cell result = null;
        int bias = left ? 0 : -2;

        for (int i = 0; i < 3; i++) {
            Cell forCheck = new Cell(Math.abs(bias + i), i);

            if (game.whose_cell(forCheck) == player)
                playerCounter++;
            if (game.is_free(forCheck))
                result = forCheck;
        }

        if (playerCounter == 2)
            return result;
        return null;
    }

}

