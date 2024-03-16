package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button AddOfWatchButton;
    @FXML
    private Button ExpensiveClockButton;
    @FXML
    private Button CheapestClockButton;
    @FXML
    private Button PrintClocksButton;
    @FXML
    private Button PopularBrandButton;
    @FXML
    private Button SetStartTimeButton;
    @FXML
    private Button PlusTimeButton;
    @FXML
    private Button WatchesBrandButton;
    @FXML
    void AddOfWatchClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddClock.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: Add Of Watches");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
    @FXML
    void ExpensiveClockClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ExpensiveClockView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: The Most Expensive Clock");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }
    @FXML
    void CheapestClockClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CheapestClockView.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: The Most Cheapest Clock");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void PrintClocksClicked(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrintClocks.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: Store Catalog");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void PopularBrandClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PopularBrand.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: The Most Popular Brand");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void SetStartTimeClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SetStartTime.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: Set Start Time for all Clocks");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void PlusTimeClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PlusTime.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: Change Time Settings for all Watches");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void WatchesBrandClicked(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WatchesBrand.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Clock's Shop: Watches Brands");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }
}



