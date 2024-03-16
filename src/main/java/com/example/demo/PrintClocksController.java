package com.example.demo;

import com.example.demo.Logic.InterfaceOfClock;
import com.example.demo.Logic.ShopOfClocks;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PrintClocksController {

    @FXML
    private Button DeleteButton;
    @FXML
    private Button NextButton;

    @FXML
    private Button PreviousButton;

    @FXML
    private Label _StoreCatalog;

    private int i;

    private int size;

    private ShopOfClocks shop;

    @FXML
    private void initialize() {

        shop = HelloApplication.getInstance().getShop();

        i = -1;
        DeleteButton.visibleProperty().set(false);
        size = shop.ReturnSize();
        _StoreCatalog.setText(" Store Catalog: " + "\n" +
                " Clocks in Shop is = " + size + "\n" +
                " Press Button 'Next' to see it!");
    }

    @FXML
    private void ini(int i) {
        PreviousButton.visibleProperty().set(true);
        NextButton.visibleProperty().set(true);
        DeleteButton.visibleProperty().set(true);
        try {
            InterfaceOfClock clock = shop.PrintAllClocks(i);
            _StoreCatalog.setText(" Clock(" + (i + 1) + ")" + "\n" + clock.toString());
        }
        catch (IndexOutOfBoundsException e) {
            if (i < 0) {
                PreviousButton.visibleProperty().set(false);
                DeleteButton.visibleProperty().set(false);
                NextButton.visibleProperty().set(true);
                _StoreCatalog.setText(" Press 'Next'!!!");
            }
            if (i >= size) {
                PreviousButton.visibleProperty().set(true);
                NextButton.visibleProperty().set(false);
                DeleteButton.visibleProperty().set(false);
                _StoreCatalog.setText(" Catalog is over, " + "\n" + " Press 'Previous' to see clocks");
            }
        }
    }
    @FXML
    void NextClicked(MouseEvent event) {
         ini(++i);
    }

    @FXML
    void PreviousClicked(MouseEvent event) {
        ini(--i);
    }

    @FXML
    void DeleteClicked(MouseEvent event) {
        try {
            shop.DeleteOfWatch(shop.PrintAllClocks(i));
            initialize();
        }
        catch (IndexOutOfBoundsException ex) {
            initialize();
        }
    }
}

