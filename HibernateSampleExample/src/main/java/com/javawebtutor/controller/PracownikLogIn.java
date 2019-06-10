package com.javawebtutor.controller;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PracownikLogIn {

    @FXML
    void LogIn(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/PracownikPage.fxml", "PracownikPage");
    }

}
