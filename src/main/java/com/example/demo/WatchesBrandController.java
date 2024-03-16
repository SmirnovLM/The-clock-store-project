package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WatchesBrandController {

    @FXML
    private Label _WatchesBrands;

    @FXML
    private void initialize() {
        _WatchesBrands.setText(HelloApplication.getInstance().getShop().PrintBrands());
    }
}
