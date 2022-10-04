package com.bashko.itmo.guessthenumber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class GuessTheNumberPlay extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuessTheNumberPlay.class.getResource("start_menu.fxml"));

        stage.setTitle("Guess the Number");
        stage.setScene(new Scene(fxmlLoader.load(),580, 480));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
