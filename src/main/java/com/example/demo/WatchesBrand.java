package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WatchesBrand extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("WatchesBrand.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
