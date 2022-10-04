package com.bashko.itmo.guessthenumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultLostController {
    private Service service;

    @FXML
    private Label desireNumberResult;

    @FXML
    private void initialize() {
        service = Service.getInstance();
        desireNumberResult.setText(Integer.toString(service.getDesireNumber()));
    }

    public void enterOkResultLost(ActionEvent event) {

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close(); //закрытие текущего Stage

        service.getStageStack().pop().close(); //закрытие предыдущего Stage (основного игрового поля)

        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start_menu.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader.load(), 580, 480));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
