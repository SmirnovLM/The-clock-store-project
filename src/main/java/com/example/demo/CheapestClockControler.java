package com.example.demo;

import com.example.demo.Logic.InterfaceOfClock;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CheapestClockControler {

    @FXML
    private Label _CheapestClock;

    @FXML
    private void initialize() {
        InterfaceOfClock clock = HelloApplication.getInstance().getShop().Information_About_The_cheapest_Watches();
        _CheapestClock.setText(clock.toString());
    }
}
