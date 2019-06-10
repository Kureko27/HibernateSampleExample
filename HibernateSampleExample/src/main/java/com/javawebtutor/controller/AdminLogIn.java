package com.javawebtutor.controller;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminLogIn {

    @FXML
    void LogIn(ActionEvent event) {
    	FXMLUtil.showAndCloseWindow(event, "/fxml/AdminPage.fxml", "AdminPage");

    }

}
