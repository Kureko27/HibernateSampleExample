package com.javawebtutor;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

//import java.util.Optional;

public class FXMLUtil {
    
        public static void showWindow(Event event, String path, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLUtil.class.getResource(path));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(new Scene(root));

            newStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.showAndWait();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void showAndHideWindow(Event event, String path, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLUtil.class.getResource(path));
        Parent root;
        try {
            final Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(new Scene(root));
            newStage.showAndWait();
            stage.show();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    } 

    public static void showAndCloseWindow(Event event, String path, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(FXMLUtil.class.getResource(path));
        Parent root;
        try {
            final Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            root = fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void closeWindow(Event event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

}
