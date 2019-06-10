package com.javawebtutor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;

public class klientPubPage {

    @FXML
    private TableView<?> viewTable;

    @FXML
    void goBack(ActionEvent event) {
    	FXMLUtil.closeWindow(event);

    }

    @FXML
    void showKlienci(ActionEvent event) {

    }

    @FXML
    void showTytuly(ActionEvent event) {

    }

}
