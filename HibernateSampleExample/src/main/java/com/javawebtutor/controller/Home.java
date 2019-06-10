package com.javawebtutor.controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import com.javawebtutor.FXMLUtil;

public class Home {

    @FXML
    void exit(ActionEvent event) {
    	FXMLUtil.closeWindow(event);

    }

    @FXML
    void goToAdminPage(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/AdminLogIn.fxml", "Admin");

    }

    @FXML
    void goToKlientPubPage(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/klientPublicznyLogIn.fxml", "KlientPub");

    }

    @FXML
    void goToKlientSamPage(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/klientSamodzielnyLogIn.fxml", "KlientSam");

    }

    @FXML
    void goToPracownikPage(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/PracownikLogIn.fxml", "Pracownik");

    }

}
