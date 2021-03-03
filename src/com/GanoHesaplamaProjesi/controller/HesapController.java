package com.GanoHesaplamaProjesi.controller;

import com.GanoHesaplamaProjesi.Model.Ders;
import com.GanoHesaplamaProjesi.Model.DersData;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HesapController implements Initializable{

    @FXML
    private BorderPane menu;
    @FXML
    private ListView<Ders> derslerim;

    @FXML
    private Label secilenDersAdi;

    @FXML
    private Label secilenEcts;

    @FXML
    private Label secilenNot;

    @FXML
    private Label gano;

    @FXML
    void kaydetBtn(ActionEvent event) {
        gano.setText(String.valueOf(DersData.getInstance().GanoHesapla()));
    }

    @FXML
    void silBtn(ActionEvent event) {

        DersData.getInstance().dersiSil(derslerim.getSelectionModel().getSelectedItem());
    }

    @FXML
    void ekleBtn(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ectsKaydet.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 630, 366);
            Stage stage = new Stage();
            stage.setTitle("Ders Bilgileri");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("asdasdasd");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Listeye elemanları listeleme
        derslerim.setItems(DersData.getInstance().getDersListesi());

        derslerim.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        derslerim.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Ders>() {
            @Override
            public void onChanged(Change<? extends Ders> change) {
                Ders secilen=derslerim.getSelectionModel().getSelectedItem();
                secilenDersAdi.setText(secilen.getAd());
                secilenEcts.setText(String.valueOf(secilen.getEcts()));
                secilenNot.setText(secilen.getHarf().toUpperCase(Locale.ROOT));
            }
        });

        secilenDersAdi.setText("");
        secilenNot.setText("");
        secilenEcts.setText("");
    }
}
