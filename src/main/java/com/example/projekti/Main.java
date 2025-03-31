package com.example.projekti;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Tätä luokkaa käytetään appin käyttämiseksi, se käyttää JavaFX Application-luokkaa.
 * Se tarjoaa käyttöliittymän koiran ruokintatietojen tallennukseen ja hakuun, tietojen
 * kuten nimi, paino, annoskoko ja ruokinta-aika.
 *
 * @author Heidi Sormunen
 * @version 1.0
 *
 */

public class Main extends Application {

    /**
     * luodaan tiedostoHandler-olio sekä ateriaLista-listaolio
     */

    private TiedostoHandler tiedostoHandler = new TiedostoHandler();
    private ListView<String> ateriaLista = new ListView<>();

    /**
     * Ohjelmaikkunan käynnistyksen ja toiminnallisuuksien määrittely
     * @param stage pääikkuna applikaatiolla, johon applikaation näkymä asetetaan.
     */
    @Override
    public void start(Stage stage) {

        /**
         * Luodaan labelit sekä kentät tietojen kirjoittamiselle.
         * Kentille säädetään maksimileveys sekä sijainti center.
         * Luodaan label, joka ilmoittaa tietojen onnistuneesta/epäonnistuneesta
         * tallennuksesta; viestiLabel.
         */


        Label koiraLabel = new Label("Koiran nimi: ");
        /**
         * Koiran nimi tekstikenttä.
         */
        TextField koiranNimiField = new TextField();
        koiranNimiField.setMaxWidth(100);

        Label koiranPainoLabel = new Label("Koiran paino (kg): ");
        /**
         * Koiran paino tekstikenttä.
         */
        TextField koiranPainoField = new TextField();
        koiranPainoField.setMaxWidth(100);

        Label annosLabel = new Label("Annos (g): ");
        /**
         * Ruoka-annos tekstikenttä.
         */
        TextField annosField = new TextField();
        annosField.setMaxWidth(100);

        Label aikaLabel = new Label("Kellonaika: ");
        Label huomautusLabel = new Label("huom. syötä kellonaika muodossa hh:mm");
        /**
         * Kellonaika tekstikenttä.
         */
        TextField aikaField = new TextField();
        aikaField.setMaxWidth(100);

        Label viestiLabel = new Label();

        /**
         * Painike tietojen tallentamiselle
         */

        Button tallennaButton = new Button("Tallenna");
        /**
         * Painike tietojen hakemiselle.
         */
        Button haeButton = new Button("Hae tiedot");

        //käsitellään tallenna-painikkeen tapahtumat
        tallennaButton.setOnAction(e -> {
            /**
             * getText hakee käyttäjän antamat tiedot kentistä
             * tiedot tallennetaan ja kellonaikasyöte tarkistetaan.
             *
             * Varmistetaan, että kellonaika on oikeassa muodossa (hh:mm).
             * @throws DateTimeParseException jos kellonaika on syötetty väärässä muodossa.
             *
             * Luodaan Ruoka-olio käyttäjän syöttämillä tiedoilla, ja tallennetaan tallennaAteria-metodilla.
             *
             * Ilmoitetaan onnistuneesta tallennuksesta, ja tyhjennetään kentät tallentamisen jälkeen.
             *
             * @throws NumberFormatException jos lukua ei syötetä kenttään tai se ei ole kelvollista muotoa.
             */

            try {
                String nimi = koiranNimiField.getText();
                double paino = Double.parseDouble(koiranPainoField.getText());
                double annos = Double.parseDouble(annosField.getText());
                String kellonaika = aikaField.getText().trim();

                if (!kellonaika.matches("\\d{2}:\\d{2}")) {
                    throw new DateTimeParseException("Aika on virheellinen", kellonaika, 0);
                }

                LocalTime.parse(kellonaika);

                Ruoka ateria = new Ruoka(nimi, paino, annos, kellonaika);
                tiedostoHandler.tallennaAteria(ateria);

                viestiLabel.setText("Tiedot tallennettu !");

                koiranNimiField.clear();
                koiranPainoField.clear();
                annosField.clear();
                aikaField.clear();

            } catch (NumberFormatException ex){
                viestiLabel.setText("Tarkista syötteet.");
            } catch (DateTimeParseException ex) {
                viestiLabel.setText("Syötä aika muodossa hh:mm ");
            }
        });

        /**
         * haeButtonin toiminnallisuus.
         */

        haeButton.setOnAction(e -> haeTiedot());


        VBox layout = new VBox(10, koiraLabel, koiranNimiField,
                koiranPainoLabel, koiranPainoField, annosLabel, annosField,
                aikaLabel, huomautusLabel, aikaField, tallennaButton, haeButton, viestiLabel, ateriaLista);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 620);
        stage.setTitle("Koiranruoka appi");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodi, joka hakee tiedot aterioihin liittyen ja päivittää käyttöliittymässä
     * näkyvän listan. Metodi tyhjentää nykyiset tiedot listasta, hakee tiedot aterioista
     * tiedostosta tiedostoHandler-olion avulla ja päivittää listan haetuilla aterioiden tiedoilla.
     *
     */

    public void haeTiedot() {
        ateriaLista.getItems().clear(); // tyhjennetään lista ensin
        List<Ruoka> ateriat = tiedostoHandler.lataaAteria();

        for (Ruoka ateria : ateriat) {
            ateriaLista.getItems().add(ateria.getDetails());
        }
    }

    /**
     * Ohjelman käynnistävä metodi.
     * @param args kutsuparametreja ei käytetä.
     */

    public static void main(String[] args) {
        launch(args);
    }
}

