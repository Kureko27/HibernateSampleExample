package com.javawebtutor.controller;

import com.javawebtutor.FXMLUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class PracownikPage {

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
    void showPracownicy(ActionEvent event) {

    }

    @FXML
    void showTytuly(ActionEvent event) {

    }

}
