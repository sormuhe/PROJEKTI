package com.example.projekti;

import java.time.LocalTime;

/**
 * Ruoka-luokka, joka perii Koira-luokasta metodit ja ominaisuudet
 */
    public class Ruoka extends Koira {

    /**
     * Olio Ruoka-luokasta
     * @param koiranNimi syötetään koiran nimi
     * @param annos syötetään koiralle annettu ruoka-annoksen koko (g)
     * @param koiranPaino syötetään koiran paino (kg)
     * @param time syötetään ruoan antoaika
     */
        public Ruoka(String koiranNimi, double annos, double koiranPaino, String time) {

            super(koiranNimi, annos, koiranPaino, LocalTime.parse(time.replace(".", ":")));

        }

    /**
     * Hakee tiedostosta tiedot, jotka käyttäjä on tallentanut.
     * @return palauttaa: koiran nimi, paino, ruoka-annoksen koon sekä antoajankohdan
     * Metodi palauttaa merkkijonona annetut arvot.
     */
    @Override
        public String getDetails() {
            return getKoiranNimi() + ": " + getKoiranPaino() + " kg, " + getAnnos() + " g, "  + getTime();
        }

    /**
     * Hakee ja palauttaa koiran nimen.
     * @return koiran nimi merkkijonona
     */
    public String getNimi() {
            return getKoiranNimi();
        }

    }

