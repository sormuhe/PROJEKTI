package com.example.projekti;

import java.time.LocalTime;

/***
 * Tätä luokkaa käytetään koiran tietojen käsittelyyn,
 * kuten nimi ja paino
 * @author Heidi Sormunen
 *
 */

public class Koira extends Ruoka {

    public Koira(String koiranNimi, double annos, double koiranPaino, LocalTime time) {
        super(koiranNimi, annos, koiranPaino, time);
    }

    @Override
    public String getDetails() {
        return "";
    }
}
