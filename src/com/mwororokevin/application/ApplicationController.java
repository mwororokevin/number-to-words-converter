package com.mwororokevin.application;

import java.awt.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    @FXML
    private void clearText(ActionEvent event) {

    }

    @FXML
    private void convertNumber(ActionEvent event) {

    }

    @FXML
    private void copyText(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
