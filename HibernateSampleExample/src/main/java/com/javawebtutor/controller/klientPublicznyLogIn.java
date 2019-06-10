package com.javawebtutor.controller;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class klientPublicznyLogIn {

    @FXML
    void LogIn(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/klientPublicznyLogIn.fxml", "KlientPubLogIn");

    }

}
