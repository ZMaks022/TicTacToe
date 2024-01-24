package com.example.tictactoe.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooseLevelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void startEasyGame(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictac/single-game-view.fxml"));
//            Parent root = loader.load();
//
//            SingleGameController controller = loader.getController();
//            controller.setEasyGame(); // need to rewrite
//
//            Scene scene = new Scene(root);
//            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
//
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void startMiddleGame(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tictac/single-game-view.fxml"));
//            Parent root = loader.load();
//
//            SingleGameController controller = loader.getController();
//            controller.setMiddleGame(); // need to rewrite
//
//            Scene scene = new Scene(root);
//            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
//
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @FXML
    void initialize() {

    }

}
