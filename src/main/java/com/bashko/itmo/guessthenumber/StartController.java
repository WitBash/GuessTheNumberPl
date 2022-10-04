package com.bashko.itmo.guessthenumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    private Service service;

    @FXML
    private ToggleGroup tg;
    @FXML
    private RadioButton easyLevel;
    @FXML
    private RadioButton mediumLevel;
    @FXML
    private RadioButton hardLevel;

    @FXML
    private void initialize() {
        tg = new ToggleGroup();
        easyLevel.setToggleGroup(tg);
        mediumLevel.setToggleGroup(tg);
        hardLevel.setToggleGroup(tg);

        service = Service.getInstance();
    }

    @FXML
    public void onStartGame(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("play_menu.fxml"));
        try {
            stage.setScene(new Scene(fxmlLoader2.load(), 580, 480));
            service.getStageStack().push(stage); // сохранение основного игрового поля(объекта Stage)
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void easyLevelPlay(ActionEvent actionEvent) {
        service.playRules(easyLevel.getText());
    }

    @FXML
    public void mediumLevelPlay(ActionEvent actionEvent) {
        service.playRules(mediumLevel.getText());
    }

    @FXML
    public void hardLevelPlay(ActionEvent actionEvent) {
        service.playRules(hardLevel.getText());
    }
}