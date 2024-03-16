package com.example.demo;

import com.example.demo.Logic.ThrowException;
import com.example.demo.Logic.TimeType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class SetStartTimeController {
    @FXML
    private Label _Error;

    @FXML
    private Button SetTimeButton;

    @FXML
    private CheckBox _Hours;

    @FXML
    private CheckBox _Minutes;

    @FXML
    private CheckBox _Seconds;

    @FXML
    private TextField _Value;

    private TimeType vt;

    @FXML
    void HoursClicked(MouseEvent event) {
        if (_Hours.isSelected()) {
            vt = TimeType.Hours;
            _Minutes.setSelected(false);
            _Seconds.setSelected(false);
        }
        else {
            vt = null;
        }
    }

    @FXML
    void MinutesClicked(MouseEvent event) {
        if (_Minutes.isSelected())
        {
            vt = TimeType.Minutes;
            _Hours.setSelected(false);
            _Seconds.setSelected(false);
        }
        else {
            vt = null;
        }
    }

    @FXML
    void SecondsClicked(MouseEvent event) {
        if (_Seconds.isSelected()) {
            vt = TimeType.Seconds;
            _Hours.setSelected(false);
            _Minutes.setSelected(false);
        }
        else {
            vt = null;
        }
    }

    @FXML
    void SetTimeClicked(MouseEvent event) throws ThrowException {
        String value_str = _Value.getText();
        int value_int = -1;

        try {
            value_int = Integer.parseInt(value_str);
        }
        catch (NumberFormatException ex) {
            _Error.setTextFill(Color.RED);
            _Error.setText("Value isn't Corrected OR The TimeType isn't specified");
        }
        try {
            HelloApplication.getInstance().getShop().SetStartTimeOfAllWatches(vt, value_int);
            _Error.setTextFill(Color.GREEN);
            _Error.setText("All Right");
        }
        catch (ThrowException ex) {
            _Error.setTextFill(Color.RED);
            _Error.setText("Value isn't Corrected OR The TimeType isn't specified");
        }

        new Thread(()->{
            try {
                Thread.sleep(1000);
                Platform.runLater(
                        ()->{
                            _Hours.setSelected(false);
                            _Minutes.setSelected(false);
                            _Seconds.setSelected(false);
                            vt = null;
                            _Value.clear();
                            _Error.setText("");
                        }
                );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
