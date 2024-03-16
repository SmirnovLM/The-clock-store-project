package com.example.demo;

import com.example.demo.Logic.InterfaceOfClock;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ExpensiveClockControler {

    @FXML
    private Label _ExpensiveClock;
    @FXML
    private void initialize() {
        InterfaceOfClock clock = HelloApplication.getInstance().getShop().Information_About_The_Most_Expensive_Watches();
        _ExpensiveClock.setText(clock.toString());
    }
}
