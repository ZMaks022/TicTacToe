package com.example.tictactoe.utilities;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InfoBar {
    @FXML
    private Label info_bar;

    /**
     * Constructs an InfoBar instance with the given Label.
     * The InfoBar is used to display different types of messages with varying styles.
     *
     * @param bar The Label UI element used for displaying information.
     */
    public InfoBar (Label bar) {
        info_bar = bar;
    }

    /**
     * Change style of bar to an error message.
     *
     * @param text The message to be displayed.
     */
    public void error (String text) {
        change_style(text, "info-bar-error");
    }

    /**
     * Change style of bar to an normal message.
     *
     * @param text The message to be displayed.
     */
    public void normal (String text) {
        change_style(text, "info-bar-normal");
    }

    /**
     * Change style of bar to an win message.
     *
     * @param text The message to be displayed.
     */
    public void win (String text) {
        change_style(text, "info-bar-win");
    }

    /**
     * Change style of bar to an lose message.
     *
     * @param text The message to be displayed.
     */
    public void lose (String text) {
        change_style(text, "info-bar-lose");
    }

    /**
     * Changes the style of the info bar based on the specified text and style class.
     * This private method is used internally to update the info bar's content and style.
     *
     * @param text The text to be displayed in the info bar.
     * @param style The CSS class that defines the style of the info bar.
     */
    private void change_style(String text, String style) {
        info_bar.setText(text);
        info_bar.getStyleClass().clear();
        info_bar.getStyleClass().add(style);
    }
}
