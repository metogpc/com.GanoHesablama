package com.GanoHesaplamaProjesi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KayitController {


    @FXML
    private TextField dersAdi;

    @FXML
    private TextField ects;

    @FXML
    private TextField harfNotu;


    @FXML
    private Button kaydetBtn;

    @FXML
    void kaydetBtn(ActionEvent event) {

        Ders ders=new Ders(dersAdi.getText(), harfNotu.getText(), Integer.parseInt(ects.getText()));
        DersData.getInstance().dersEkle(ders);
        Stage stage = (Stage) kaydetBtn.getScene().getWindow();
        stage.close();
    }
}
