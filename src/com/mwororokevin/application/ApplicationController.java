package com.mwororokevin.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * @author Kevin Kamau Mwororo
 * @author website mwororokevin.com
 * @author email mwororokevin@gmail.com
 */

public class ApplicationController implements Initializable {
    
    @FXML
    private TextField inputTxtField;

    @FXML
    private Label warningFeedbackLbl;

    @FXML
    private TextArea outputTextArea;
    
    /**
     * Clears the text in the TextArea with the fx id outputTextArea
     * @param event 
     */
    @FXML
    private void clearText(ActionEvent event) {
        outputTextArea.setText("");
    }

    @FXML
    private void convertNumber(ActionEvent event) {

    }

    @FXML
    private void copyText(ActionEvent event) {

    }
    
    /**
     * Prevents the TextField from accepting anything but an integer.
     * Returns a message warning the user.
     */
    private void validateNumberInput() {
        inputTxtField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                char keyInput = event.getCharacter().charAt(0);
                if((keyInput < '0' || keyInput > '9') && keyInput != '\b') {
                    event.consume();
                    warningFeedbackLbl.setText("Only digits allowed.");
                }
            }
        });
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validateNumberInput();
    }    
    
}
