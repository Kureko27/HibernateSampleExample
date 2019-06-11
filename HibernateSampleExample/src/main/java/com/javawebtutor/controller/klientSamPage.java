package com.javawebtutor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.javawebtutor.FXMLUtil;
import com.javawebtutor.model.KlientPubliczny;
import com.javawebtutor.model.KlientSamodzielny;
import com.javawebtutor.model.Tytul;
import com.javawebtutor.service.Manager;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class klientSamPage {

    @FXML
    private TableView viewTable;

    @FXML
    void goBack(ActionEvent event) {
    	FXMLUtil.closeWindow(event);

    }

    @FXML
    void showKlienci(ActionEvent event) {
    	TableColumn<KlientSamodzielny, String> nazwa = new TableColumn<>("Nazwa");
        nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        TableColumn<KlientSamodzielny, Integer> id_klientSamodzielny = new TableColumn<>("id_klientSamodzielny");
        id_klientSamodzielny.setCellValueFactory(new PropertyValueFactory<>("id_klientSamodzielny"));
        
        TableColumn<KlientSamodzielny, String> imie = new TableColumn<>("imie");
        imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        
        TableColumn<KlientSamodzielny, String> nazwisko = new TableColumn<>("Nazwisko");
        nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        
        TableColumn<KlientSamodzielny, Integer> pesel = new TableColumn<>("pesel");
        pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));

        TableColumn<KlientSamodzielny, String> oddzial = new TableColumn<>("Oddzial");
		oddzial.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getOddzial().getkraj()));

        viewTable.getColumns().addAll(nazwa, id_klientSamodzielny, imie, nazwisko, oddzial);

        Manager manager = new Manager();
        
        final ObservableList<KlientSamodzielny> data = FXCollections.observableArrayList(manager.getAllKlientSamodzielny());
        viewTable.setItems(data);

    }

    @FXML
    void showTytuly(ActionEvent event) {
    	TableColumn<Tytul, String> nazwa = new TableColumn<>("Nazwa");
        nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));

        TableColumn<Tytul, Integer> id_tytul = new TableColumn<>("id_tytul");
        id_tytul.setCellValueFactory(new PropertyValueFactory<>("id_tytul"));

        TableColumn<Tytul, String> klientPubliczny = new TableColumn<>("KlientPub");
        klientPubliczny.setCellValueFactory(celldata -> {
            KlientPubliczny klient = celldata.getValue().getklientPubliczny();
            return new SimpleStringProperty(klient.getimie() + " " + klient.getnazwisko());
        });

        TableColumn<Tytul, String> klientSamodzielny = new TableColumn<>("KlientSam");
        klientSamodzielny.setCellValueFactory(celldata -> {
            KlientSamodzielny klientS = celldata.getValue().getklientSamodzielny();
            return new SimpleStringProperty(klientS.getimie() + " " + klientS.getnazwisko());
        });

        TableColumn<Tytul, String> stan = new TableColumn<>("Stan");
		stan.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getstanTytulu().getnazwa()));

        viewTable.getColumns().addAll(nazwa, id_tytul, klientPubliczny, klientSamodzielny, stan);

        Manager manager = new Manager();
        
        final ObservableList<Tytul> data = FXCollections.observableArrayList(manager.getAllTytul());
        viewTable.setItems(data);

    }

}
