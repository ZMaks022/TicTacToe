package com.example.tictactoe.game;

import com.example.tictactoe.bots.Bot;
import com.example.tictactoe.bots.EasyBot;

/**
 * Constructs a new Tic-Tac-Toe game instance.
 * Initializes the game board and provides game management functions.
 */
public class Game {
    protected final int[][] map = new int[3][3];
    protected int steps = 0;
    protected WinLine line = null;
    protected Winner winner = Winner.UNKNOWN;

    /**
     * Constructs a new Tic-Tac-Toe game instance.
     * Initializes the game board and sets the initial state.
     */
    public Game() {
        reset();
    }

    /**
     * Resets the game to its initial state.
     * Clears the game board, resets the number of steps, and sets the winner to UNKNOWN.
     */
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 0;
            }
        }
        line = null;
        winner = Winner.UNKNOWN;
        steps = 0;
    }

    /**
     * Checks if the game is over by evaluating the game board for any winning conditions.
     * Updates the winner and winning line if a win condition is met.
     *
     * @return true if the game is over (win, lose or draw), false otherwise.
     */
    public boolean check_game_over() {
        // check TOP_HORIZONTAL
        if (map[0][0] + map[0][1] + map[0][2] == 3) {
            line = WinLine.TOP_HORIZONTAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][0] + map[0][1] + map[0][2] == 300) {
            line = WinLine.TOP_HORIZONTAL;
            winner = Winner.PLAYER_TWO;
        }

        // check MIDDLE_HORIZONTAL
        else if (map[1][0] + map[1][1] + map[1][2] == 3) {
            line = WinLine.MIDDLE_HORIZONTAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[1][0] + map[1][1] + map[1][2] == 300) {
            line = WinLine.MIDDLE_HORIZONTAL;
            winner = Winner.PLAYER_TWO;
        }

        // check BOTTOM_HORIZONTAL
        else if (map[2][0] + map[2][1] + map[2][2] == 3) {
            line = WinLine.BOTTOM_HORIZONTAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[2][0] + map[2][1] + map[2][2] == 300) {
            line = WinLine.BOTTOM_HORIZONTAL;
            winner = Winner.PLAYER_TWO;
        }

        // check LEFT_VERTICAL
        else if (map[0][0] + map[1][0] + map[2][0] == 3) {
            line = WinLine.LEFT_VERTICAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][0] + map[1][0] + map[2][0] == 300) {
            line = WinLine.LEFT_VERTICAL;
            winner = Winner.PLAYER_TWO;
        }

        // check MIDDLE_VERTICAL
        else if (map[0][1] + map[1][1] + map[2][1] == 3) {
            line = WinLine.MIDDLE_VERTICAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][1] + map[1][1] + map[2][1] == 300) {
            line = WinLine.MIDDLE_VERTICAL;
            winner = Winner.PLAYER_TWO;
        }

        // check RIGHT_VERTICAL
        else if (map[0][2] + map[1][2] + map[2][2] == 3) {
            line = WinLine.RIGHT_VERTICAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][2] + map[1][2] + map[2][2] == 300) {
            line = WinLine.RIGHT_VERTICAL;
            winner = Winner.PLAYER_TWO;
        }

        // check LEFT_TO_RIGHT_DIAGONAL
        else if (map[0][0] + map[1][1] + map[2][2] == 3) {
            line = WinLine.LEFT_TO_RIGHT_DIAGONAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][0] + map[1][1] + map[2][2] == 300) {
            line = WinLine.LEFT_TO_RIGHT_DIAGONAL;
            winner = Winner.PLAYER_TWO;
        }

        // check RIGHT_TO_LEFT_DIAGONAL
        else if (map[0][2] + map[1][1] + map[2][0] == 3) {
            line = WinLine.RIGHT_TO_LEFT_DIAGONAL;
            winner = Winner.PLAYER_ONE;
        }
        else if (map[0][2] + map[1][1] + map[2][0] == 300) {
            line = WinLine.RIGHT_TO_LEFT_DIAGONAL;
            winner = Winner.PLAYER_TWO;
        }

        else if (steps == 9) {
            winner = Winner.DRAW;
        }

        return winner != null;
    }

    /**
     * Records a player's move on the game board.
     *
     * @param cl The cell where the player makes the move.
     * @param player The player making the move (PLAYER_ONE or PLAYER_TWO).
     */
    public void make_step(Cell cl, Player player) {
        if (player == Player.PLAYER_ONE) {
            map[cl.getRow()][cl.getColumn()] = 1;
        } else {
            map[cl.getRow()][cl.getColumn()] = 100;
        }

        steps++;
    }

    /**
     * Checks if a specific cell on the game board is free.
     *
     * @param cl The cell to check.
     * @return true if the cell is free, false otherwise.
     */
    public boolean is_free(Cell cl) {
        return map[cl.getRow()][cl.getColumn()] == 0;
    }

    /**
     * Determines which player occupies a specific cell.
     *
     * @param cl The cell to check.
     * @return The player occupying the cell (PLAYER_ONE or PLAYER_TWO), or null if the cell is free.
     */
    public Player whose_cell(Cell cl) {
        if (map[cl.getRow()][cl.getColumn()] == 1)
            return Player.PLAYER_ONE;
        else if (map[cl.getRow()][cl.getColumn()] == 100)
            return Player.PLAYER_TWO;
        return null;
    }

    /**
     * Checks if the game has ended.
     *
     * @return true if the game is over, false otherwise.
     */
    public boolean is_game_over() {
        return winner != Winner.UNKNOWN;
    }

    /**
     * Gets the winner of the game.
     *
     * @return The winner of the game (PLAYER_ONE, PLAYER_TWO, or DRAW). Returns UNKNOWN if the game is not over.
     */
    public Winner who_win() {
        return winner;
    }

    /**
     * Gets the winning line if the game is over.
     *
     * @return The winning line, or null if there's no winner yet.
     */
    public WinLine getLine() {
        return line;
    }
}
