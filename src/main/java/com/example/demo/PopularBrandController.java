package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopularBrandController {

    @FXML
    private Label _PopularBrand;

    @FXML
    private void initialize() {
        _PopularBrand.setText(" " + HelloApplication.getInstance().getShop().The_Most_Popular_Watch_Brand());
    }
}
