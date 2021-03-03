package com.GanoHesaplamaProjesi;

import com.GanoHesaplamaProjesi.Model.DersData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void init() throws Exception {
        DersData.getInstance().DersleriDosyadanGetir();
        DersData.getInstance().GanoHesapla();
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("" + "view/ectsHesabi.fxml"));
        primaryStage.setTitle("Aibu GANO Hesaplama");
        primaryStage.setScene(new Scene(root, 749, 494));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        DersData.getInstance().DersleridosyayaYaz();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
