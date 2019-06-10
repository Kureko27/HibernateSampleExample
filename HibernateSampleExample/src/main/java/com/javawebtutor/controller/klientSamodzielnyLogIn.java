package com.javawebtutor.controller;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class klientSamodzielnyLogIn {

    @FXML
    void LogIn(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/klientSamodzielnyLogIn.fxml", "KlientSamLogIn");

    }

}
