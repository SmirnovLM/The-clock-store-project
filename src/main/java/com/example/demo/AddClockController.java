package com.example.demo;

import com.example.demo.Logic.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class AddClockController {
    @FXML
    private Label _Error;
    @FXML
    private Button AddTheWatchesButton;

    @FXML
    private TextField _CostOfWatches;

    @FXML
    private CheckBox _NotEmpty;

    @FXML
    private TextField _TheValueOfTheHourHand;

    @FXML
    private TextField _TheValueOfTheMinuteHand;

    @FXML
    private TextField _TheValueOfTheSecondHand;

    @FXML
    private TextField _WatchBrand;

    @FXML
    boolean flag;

    @FXML
    void AddTheWatchesClicked(MouseEvent event) throws ThrowException{

        String brand = _WatchBrand.getText();
        String cost_str = _CostOfWatches.getText();
        String hour_str = _TheValueOfTheHourHand.getText();
        String minute_str = _TheValueOfTheMinuteHand.getText();
        String second_str = _TheValueOfTheSecondHand.getText();

        int cost_int = 0, hour_int = 0, minute_int = 0, second_int = 0;
        try {
            cost_int = Integer.parseInt(cost_str);
            hour_int = Integer.parseInt(hour_str);
            minute_int = Integer.parseInt(minute_str);
            second_int = Integer.parseInt(second_str);
        }
        catch (NumberFormatException ex) {
            _Error.setTextFill(Color.RED);
            _Error.setText("Value isn't Corrected OR The TimeType isn't specified");
        }
        InterfaceOfClock clock;
        if (!flag) {
            clock = new Clock_P(brand, cost_int, hour_int, minute_int);
        }
        else {
            clock = new Clock_C(brand, cost_int, hour_int, minute_int, second_int);
        }
        _Error.setTextFill(Color.GREEN);
        _Error.setText("All Right");
        HelloApplication.getInstance().getShop().AddOfWatch(clock);
        new Thread(()->{
            try {
                Thread.sleep(1000);
                Platform.runLater(
                        ()->{
                            _NotEmpty.setSelected(false);
                            _WatchBrand.clear();
                            _CostOfWatches.clear();
                            _TheValueOfTheHourHand.clear();
                            _TheValueOfTheMinuteHand.clear();
                            _TheValueOfTheSecondHand.clear();
                            _TheValueOfTheSecondHand.setVisible(false);
                            flag = false;
                            _Error.setText("");
                        }
                );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @FXML
    void _NotEmptyClicked(MouseEvent event) {
        flag = !flag;
        if (!flag) {
            _TheValueOfTheSecondHand.setVisible(false);
            _TheValueOfTheSecondHand.clear();
        }
        else {
            _TheValueOfTheSecondHand.setVisible(true);
        }
    }

    @FXML
    void initialize() {
        flag = false;
        _TheValueOfTheSecondHand.setVisible(false);
    }


}

