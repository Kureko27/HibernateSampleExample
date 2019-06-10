package com.javawebtutor;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class App extends Application 
{
    public static void main( String[] args )
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(new Locale("pl", "PL"));
        try {
            primaryStage.setTitle("Logowanie");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;

import org.hibernate.Session;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class App 
{
    public static void main( String[] args )
    {
    	//Session session = HibernateUtil.getSessionFactory().openSession();
        //System.out.println( "Hello World!" );
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	 
        session.beginTransaction();
        Userr user = new Userr();
 
        user.setUserId(3);
        user.setUsername("Mukesh");
        user.setCreatedBy("Google");
        user.setCreatedDate(new Date());
 
        session.save(user);
        session.getTransaction().commit();
    	
    }
}  */
