package com.example.tictactoe.controllers;

import com.example.tictactoe.game.Cell;
import com.example.tictactoe.game.Game;
import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.Winner;
import com.example.tictactoe.utilities.InfoBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ResourceBundle;

public class MultiplayerGameController extends GameController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Line BOTTOM_HORIZONTAL;
    @FXML
    private Line LEFT_TO_RIGHT_DIAGONAL;
    @FXML
    private Line LEFT_VERTICAL;
    @FXML
    private Line MIDDLE_HORIZONTAL;
    @FXML
    private Line MIDDLE_VERTICAL;
    @FXML
    private Line RIGHT_TO_LEFT_DIAGONAL;
    @FXML
    private Line RIGHT_VERTICAL;
    @FXML
    private Line TOP_HORIZONTAL;

    private Player currentPlayerStep = Player.PLAYER_ONE;

    /**
     * Handles the action event for when a game board button is clicked.
     * Manages the game progress including marking steps, checking game status, and alternating turns between players.
     *
     * @param event The ActionEvent triggered by a button click.
     */
    @FXML
    void btnClick(ActionEvent event) {
        if (game.is_game_over()) {
            return;
        }

        Button clickedButton = (Button) event.getSource();
        Cell cl = getCellByButton(clickedButton);

        // check if this cell is already filled
        if (!game.is_free(cl)) {
            bar.error("This cell already filled, please choose other cell!");
            return;
        }

        mark_step(cl, currentPlayerStep);

        game.check_game_over();
        if (game.is_game_over()) {
            if (game.who_win() == Winner.PLAYER_ONE) {
                bar.win("Player One win!");
                draw_win_line();
            }
            else if (game.who_win() == Winner.PLAYER_TWO) {
                bar.win("Player Two win");
                draw_win_line();
            }
            else if (game.who_win() == Winner.DRAW)
                bar.normal("Draw!");
            return;
        }

        if (currentPlayerStep == Player.PLAYER_ONE) {
            currentPlayerStep = Player.PLAYER_TWO;
            bar.normal("Player Two step");
        }
        else if (currentPlayerStep == Player.PLAYER_TWO) {
            currentPlayerStep = Player.PLAYER_ONE;
            bar.normal("Player One step");
        }
    }

    /**
     * Initializes the controller after its root element has been completely processed.
     * Sets up the game board and initializes the first player's turn.
     */
    @FXML
    void initialize() {
        assert BOTTOM_HORIZONTAL != null : "fx:id=\"BOTTOM_HORIZONTAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert LEFT_TO_RIGHT_DIAGONAL != null : "fx:id=\"LEFT_TO_RIGHT_DIAGONAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert LEFT_VERTICAL != null : "fx:id=\"LEFT_VERTICAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert MIDDLE_HORIZONTAL != null : "fx:id=\"MIDDLE_HORIZONTAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert MIDDLE_VERTICAL != null : "fx:id=\"MIDDLE_VERTICAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert RIGHT_TO_LEFT_DIAGONAL != null : "fx:id=\"RIGHT_TO_LEFT_DIAGONAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert RIGHT_VERTICAL != null : "fx:id=\"RIGHT_VERTICAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert TOP_HORIZONTAL != null : "fx:id=\"TOP_HORIZONTAL\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert grid_field != null : "fx:id=\"grid_field\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";
        assert info_bar != null : "fx:id=\"info_bar\" was not injected: check your FXML file 'multiplayer-game-view.fxml'.";

        game = new Game();
        bar = new InfoBar(info_bar);
        bar.normal("Player One step");
    }

}
