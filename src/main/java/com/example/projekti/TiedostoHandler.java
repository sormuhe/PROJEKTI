package com.example.projekti;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TiedostoHandler-luokka toteuttaa Tallenna-rajapinnan ja mahdollistaa Ruoka-olioiden
 * tietojen pysyväistallennuksen sekä lataamisen tiedostosta. Luokka sisältää tiedoston
 * käsittelemiseen liittyvät toiminnot, jotka mahdollistavat Ruoka-olioiden tallentamisen
 * ja lataamisen tekstimuodossa tiedostoon.
 */
public class TiedostoHandler implements Tallenna {

    /**
     * Määritellään vakio, joka sisältää ateriat.txt-tiedoston nimen
     */
    private static final String TIEDOSTON_NIMI = "ateriat.txt";

    /**
     * Metodissa tallennaAteria kutsutaan lataaAteria-metodia, joka lukee aiemmat tallennetut
     * ateriat tiedostosta ja palauttaa ne listaksi. Lista sisältää kaikki
     * aiemmin tallennetut ateriat, joita voidaan käyttää myöhemmin
     * @param ateria Ruoka-olio, joka sisältää koirasta ja annoksesta annetut tiedot.
     */
    @Override
    public void tallennaAteria(Ruoka ateria) {
        /**
         * ladataan aiemmat ateriat, ja
         * lisätään uusia
         */
        List<Ruoka> ateriat = lataaAteria();
        ateriat.add(ateria);

        /** BufferedWriter ja FileWriter luodaan, jotta voidaan kirjoittaa tiedostoon
         *
         * tiedosto avataan lisäämismoodissa (true), uusi ateria kirjoitetaan tiedoston loppuun
         * ja aikaisempia tietoja ei poisteta.
         * Tiedot kirjoitetaan tiedostoon nimi, paino, annos ja aika järjestyksessä
         * pilkulla eroteltuna riville.
         *
         * Jos tiedostoon kirjoitettaessa tapahtuu virhe, virhe käsitellään ja konsoliin
         * tulostuu virheilmoitus
         */

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TIEDOSTON_NIMI, true))) {
            writer.write(ateria.getNimi() + ", " + ateria.getKoiranPaino() + ", " +
                    ateria.getAnnos() + ", " + ateria.getTime() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodissa luodaan ensin tyhjä lista aterioille, siihen myöhemmin tallennetaan luetut ateriat.
     *
     * BufferReader ja FileReader luodaan tiedoston lukua varten, määrittely on tehty luokassa
     * aiemmin.
     *
     * Tiedosto luetaan ja try-with-resources varmistaa, että tiedosto suljetaan,
     * kun lukeminen on valmis tai tulee poikkeus.
     *
     * Tiedoston luku tapahtuu while-silmukassa rivi kerrallaan,
     * rivi.split(",") jakaa rivin osiin, tuottaa taulukon String[], jonka jokaisessa kentässä
     * on yksi tieto.
     *
     * FileNotFoundException, jos tiedostoa ei ole olemassa.
     * IOException käsittelee poikkeukset, joita voi tapahtua tiedostoja, syötettä
     * tai tulostetta käsitellessä
     *
     * @return Palauttaa listan ateriat, kun lukeminen on valmis.
     */
    @Override
    public List<Ruoka> lataaAteria() {
        List<Ruoka> ateriat = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TIEDOSTON_NIMI))) {
            String rivi;

            while ((rivi = reader.readLine()) != null) {
                String[] tiedot = rivi.split(",");

                if (tiedot.length == 4) {   // tarkistetaan, että rivillä on oikea määrä kenttiä

                    // tiedon muuntaminen ja luodaan uusi Ruoka-olio

                    String nimi = tiedot[0];
                    double paino = Double.parseDouble(tiedot[1]);
                    double annosMaara = Double.parseDouble(tiedot[2]);
                    String time = tiedot[3].trim();

                    Ruoka ateria = new Ruoka(nimi, paino, annosMaara, time);
                    ateriat.add(ateria);    // lisätään Ruoka-olio listaan
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ei aiempia tallennuksia.");

        } catch (IOException e) {
            System.out.println("Virhe tiedoston lataamisessa tai käsittelyssä.");
        }

        return ateriat;
    }
}