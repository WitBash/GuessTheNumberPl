package com.bashko.itmo.guessthenumber;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayController {

    private Service service;

    @FXML
    private ListView<Integer> lessColumn;

    @FXML
    private ListView<Integer> desireColumn;

    @FXML
    private ListView<Integer> moreColumn;

    @FXML
    private Button guessButton;

    @FXML
    private TextField playField;


    @FXML
    private void initialize() {
        lessColumn = new ListView<>(FXCollections.observableArrayList());
        desireColumn = new ListView<>(FXCollections.observableArrayList());
        moreColumn = new ListView<>(FXCollections.observableArrayList());

        service = Service.getInstance();
    }


    @FXML
    private void returnToMainMenu(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start_menu.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader.load(), 580, 480));
            service.getStageStack().pop(); // удаляем закрытый Stage из контейнера
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void guessNumber(ActionEvent event) {
        int a = Integer.parseInt(playField.getText());
        playField.clear();
        int i = service.guessNumber(a);
        if (service.getNumberOfAttempts() == 0) generateNewStage("result-lost.fxml");
        else if (i == -1) {
            lessColumn.getItems().add(a);
//            System.out.println(lessColumn.getItems().get(0));
            lessColumn.refresh();
        } else if (i == 1) {
            moreColumn.getItems().add(a);
            lessColumn.refresh();
        } else {
            desireColumn.getItems().add(a);
            lessColumn.refresh();
            generateNewStage("result-win.fxml");
        }
    }

    private void generateNewStage(String s) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(s));
        try {
            stage.setScene(new Scene(fxmlLoader.load(), 300, 200));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
