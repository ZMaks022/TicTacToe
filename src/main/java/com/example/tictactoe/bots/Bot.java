package com.example.tictactoe.bots;

import com.example.tictactoe.game.Cell;
import com.example.tictactoe.game.Game;

/**
 * Represents the bot interface for the Tic-Tac-Toe game.
 * Defines the functionality that any bot should implement to play the game.
 */
public interface Bot {
    /**
     * Generates the next move for the bot in the given game state.
     *
     * @param game The current state of the game, providing the necessary context for the bot to make a decision.
     * @return The next move as a Cell object, which indicates where the bot has decided to make its move.
     */
    public Cell generate_step(Game game);
}

