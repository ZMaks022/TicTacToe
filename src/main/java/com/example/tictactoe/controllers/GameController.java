package com.example.tictactoe.controllers;

import com.example.tictactoe.game.Cell;
import com.example.tictactoe.game.Game;
import com.example.tictactoe.game.Player;
import com.example.tictactoe.game.WinLine;
import com.example.tictactoe.utilities.InfoBar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public abstract class GameController {
    @FXML
    protected Line BOTTOM_HORIZONTAL;
    @FXML
    protected Line LEFT_TO_RIGHT_DIAGONAL;
    @FXML
    protected Line LEFT_VERTICAL;
    @FXML
    protected Line MIDDLE_VERTICAL;
    @FXML
    protected Line RIGHT_TO_LEFT_DIAGONAL;
    @FXML
    protected Line RIGHT_VERTICAL;
    @FXML
    protected Line TOP_HORIZONTAL;
    @FXML
    protected Line MIDDLE_HORIZONTAL;

    protected InfoBar bar;
    protected Game game = null;

    @FXML
    protected Label info_bar;
    @FXML
    protected GridPane grid_field;

    /**
     * Handles the click event to navigate back to the main menu.
     * This method is triggered by a mouse event on the respective UI element.
     *
     * @param event The mouse event that triggered the method.
     */
    @FXML
    protected void backToMenuClick(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictactoe/main-menu-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

            Stage stage = (Stage) grid_field.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the click event to repeat the game.
     * Resets the game state and UI elements to their initial state.
     *
     * @param event The mouse event that triggered the method.
     */
    @FXML
    protected void repeatClick(MouseEvent event) {
        // reset bar
        bar.normal("Your step");

        // reset buttons
        for (javafx.scene.Node node : grid_field.getChildren())
            ((Button) node).setText("");

        // reset win lines
        TOP_HORIZONTAL.setVisible(false);
        MIDDLE_HORIZONTAL.setVisible(false);
        BOTTOM_HORIZONTAL.setVisible(false);
        LEFT_VERTICAL.setVisible(false);
        MIDDLE_VERTICAL.setVisible(false);
        RIGHT_VERTICAL.setVisible(false);
        LEFT_TO_RIGHT_DIAGONAL.setVisible(false);
        RIGHT_TO_LEFT_DIAGONAL.setVisible(false);

        // reset game
        game.reset();
    }

    /**
     * Maps a clicked button to its corresponding cell on the game board.
     *
     * @param clickedButton The button that was clicked.
     * @return The cell on the game board that corresponds to the clicked button.
     */
    protected Cell getCellByButton(Button clickedButton) {
        Integer colIndex = grid_field.getColumnIndex(clickedButton);
        Integer rowIndex = grid_field.getRowIndex(clickedButton);

        colIndex = colIndex != null ? colIndex : 0;
        rowIndex = rowIndex != null ? rowIndex : 0;

        return new Cell(colIndex, rowIndex);
    }

    /**
     * Marks a step on the game board and updates the UI accordingly.
     * Records the player's move in the game logic and updates the button's text on the UI.
     *
     * @param cl The cell where the player made the move.
     * @param player The player making the move (PLAYER_ONE or PLAYER_TWO).
     */
    protected void mark_step(Cell cl, Player player) {
        game.make_step(cl, player);

        // search button in current posistion
        Button buttonInCell = null;
        for (javafx.scene.Node node : grid_field.getChildren()) {
            Cell second = getCellByButton((Button) node);
            if (second.getRow() == cl.getRow() && second.getColumn() == cl.getColumn()) {
                buttonInCell = (Button) node;
                break;
            }
        }

        if (player == Player.PLAYER_ONE) {
            buttonInCell.setText("X");
        } else {
            buttonInCell.setText("O");
        }
    }

    /**
     * Draws the winning line on the game board if there is a winner.
     * Visualizes the line that constitutes the winning condition on the UI.
     */
    protected void draw_win_line() {
        WinLine line = game.getLine();

        if (line == WinLine.TOP_HORIZONTAL)
            TOP_HORIZONTAL.setVisible(true);
        if (line == WinLine.MIDDLE_HORIZONTAL)
            MIDDLE_HORIZONTAL.setVisible(true);
        if (line == WinLine.BOTTOM_HORIZONTAL)
            BOTTOM_HORIZONTAL.setVisible(true);
        if (line == WinLine.LEFT_VERTICAL)
            LEFT_VERTICAL.setVisible(true);
        if (line == WinLine.MIDDLE_VERTICAL)
            MIDDLE_VERTICAL.setVisible(true);
        if (line == WinLine.RIGHT_VERTICAL)
            RIGHT_VERTICAL.setVisible(true);
        if (line == WinLine.LEFT_TO_RIGHT_DIAGONAL)
            LEFT_TO_RIGHT_DIAGONAL.setVisible(true);
        if (line == WinLine.RIGHT_TO_LEFT_DIAGONAL)
            RIGHT_TO_LEFT_DIAGONAL.setVisible(true);
    }
}
