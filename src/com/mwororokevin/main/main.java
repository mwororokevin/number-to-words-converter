package com.mwororokevin.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        
//        Initialize the stage icon image as stageIcon
        Image stageIcon = new Image("/com/mwororokevin/resources/appIcon.png");
        
        /**
         * Setting the Scene, the Stage Icon, the title, the boolean value for 
         * resizing the stage.
         */
        stage.setScene(new Scene(root));
        stage.getIcons().add(stageIcon);
        stage.setTitle("Number to Words Converter");
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
