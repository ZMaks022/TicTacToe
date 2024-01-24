package com.example.tictactoe.controllers;

import com.example.tictactoe.game.*;
import com.example.tictactoe.utilities.InfoBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SingleGameController extends GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

        // set x to current position
        mark_step(cl, Player.PLAYER_ONE);

        game.check_game_over();

        Cell second = ((SingleGame) game).next_step();
        if (second != null) {
            mark_step(second, Player.PLAYER_TWO);
        }

        game.check_game_over();

        if (game.is_game_over()) {
            if (game.who_win() == Winner.PLAYER_ONE) {
                bar.win("You win!");
                draw_win_line();
            }
            else if (game.who_win() == Winner.PLAYER_TWO) {
                bar.lose("You lose!");
                draw_win_line();
            }
            else if (game.who_win() == Winner.DRAW)
                bar.normal("Draw!");
        } else {
            bar.normal("Your step");
        }
    }

    public void setEasyGame() {
        if (game == null)
            game = new SingleGame(BotLevel.EASY_LEVEL);
    }

    public void setMiddleGame() {
        if (game == null)
            game = new SingleGame(BotLevel.MIDDLE_LEVEL);
    }

    @FXML
    void initialize() {
        assert BOTTOM_HORIZONTAL != null : "fx:id=\"BOTTOM_HORIZONTAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert LEFT_TO_RIGHT_DIAGONAL != null : "fx:id=\"LEFT_TO_RIGHT_DIAGONAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert LEFT_VERTICAL != null : "fx:id=\"LEFT_VERTICAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert MIDDLE_HORIZONTAL != null : "fx:id=\"MIDDLE_HORIZONTAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert MIDDLE_VERTICAL != null : "fx:id=\"MIDDLE_VERTICAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert RIGHT_TO_LEFT_DIAGONAL != null : "fx:id=\"RIGHT_TO_LEFT_DIAGONAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert RIGHT_VERTICAL != null : "fx:id=\"RIGHT_VERTICAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert TOP_HORIZONTAL != null : "fx:id=\"TOP_HORIZONTAL\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert grid_field != null : "fx:id=\"grid_field\" was not injected: check your FXML file 'single-game-view.fxml'.";
        assert info_bar != null : "fx:id=\"info_bar\" was not injected: check your FXML file 'single-game-view.fxml'.";

        bar = new InfoBar(info_bar);
        bar.normal("Your step");
    }

}
