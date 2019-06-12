package com.javawebtutor;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

import com.javawebtutor.service.Manager;

public class App extends Application 
{
    public static void main( String[] args )
    {
    	Manager manager = new Manager();
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(new Locale("pl", "PL"));
        try {
            primaryStage.setTitle("Home");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


