package com.example.projekti;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    private TiedostoHandler tiedostoHandler = new TiedostoHandler();

    @Override
    public void start(Stage stage) {

        Label koiraLabel = new Label("Koiran nimi: ");
        TextField koiranNimiField = new TextField();
        koiranNimiField.setMaxWidth(100);

        Label koiranPainoLabel = new Label("Koiran paino (kg): ");
        TextField koiranPainoField = new TextField();
        koiranPainoField.setMaxWidth(100);

        Label annosLabel = new Label("Annos: ");
        TextField annosField = new TextField();
        annosField.setMaxWidth(100);

        Label aikaLabel = new Label("Kellon aika: ");
        TextField aikaField = new TextField();
        aikaField.setMaxWidth(100);


        // toiminnallisuudet tallenna ja hae
        Button tallennaButton = new Button("Tallenna");
        Button haeButton = new Button("Hae tiedot");

//        tallennaButton.setOnAction(e -> {
//
//        });
//
//
//        haeButton.setOnAction(e -> {
//
//        });


        VBox layout = new VBox(10, koiraLabel, koiranNimiField,
                koiranPainoLabel, koiranPainoField, annosLabel, annosField,
                aikaLabel, aikaField, tallennaButton, haeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 420);
        stage.setTitle("Koiranruokalaskuri");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

