package com.mwororokevin.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Kevin Kamau Mwororo
 * @author website mwororokevin.com
 * @author email mwororokevin@gmail.com
 */

public class main extends Application {    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/mwororokevin/application/Application.fxml"));

        
        stage.setScene(new Scene(root));
        
        stage.setTitle("Number to Words Converter");
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
