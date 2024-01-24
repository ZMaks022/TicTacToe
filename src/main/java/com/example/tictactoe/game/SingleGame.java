package com.example.tictactoe.game;

import com.example.tictactoe.bots.Bot;
import com.example.tictactoe.bots.EasyBot;

public class SingleGame extends Game {
    private Bot bot;

    /**
     * Constructs a SinglePlayer Tic-Tac-Toe game with a bot opponent.
     * The difficulty level of the bot is determined by the specified BotLevel.
     *
     * @param lvl The difficulty level of the bot (EASY_LEVEL or MIDDLE_LEVEL).
     */
    public SingleGame(BotLevel lvl) {
        if (lvl == BotLevel.EASY_LEVEL)
            bot = new EasyBot();
        else if (lvl == BotLevel.MIDDLE_LEVEL)
            bot = new EasyBot(); // redo
        else
            bot = new EasyBot();

        reset();
    }

    /**
     * Constructs a SinglePlayer Tic-Tac-Toe game with an easy-level bot opponent.
     * This constructor defaults to using an EasyBot for simplicity.
     */
    public SingleGame() {
        bot = new EasyBot();

        reset();
    }

    /**
     * Computes the next step in the game.
     * If the game is not over and there are steps remaining, the bot generates its move.
     *
     * @return The next move as a Cell object if the game is ongoing, null if the game is over or no moves are left.
     */
    public Cell next_step() {
        if (this.steps != 9 && !is_game_over()) {
            return bot.generate_step(this);
        }
        return null;
    }
}
