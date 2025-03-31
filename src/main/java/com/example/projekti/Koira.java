package com.example.projekti;
import java.time.LocalTime;


abstract class Koira {

    /**
     * annetaan Koira-luokalle koiran käsittelyyn tarvittavat
     * tietokentät nimi, annos, koiran paino, koiran nimi ja aika.
     */
    private String koiranNimi;
    private double koiranPaino;
    private double annos;
    private LocalTime time;

    /**
     * Luodaan Koira-luokalle konstruktori
     * @param koiranNimi sisältää annetun koiran nimen
     * @param koiranPaino sisältää annetun koiran painon
     * @param annos sisältää annetun ruoka-annoksen
     * @param time sisältää annetun ajan
     */
    public Koira(String koiranNimi, double koiranPaino, double annos, LocalTime time) {
        this.koiranNimi = koiranNimi;
        this.koiranPaino = koiranPaino;
        this.annos = annos;
        this.time = time;
    }

    /**
     * Hakee annetun tiedon koiran nimelle
     * @return palauttaa annetun koiran nimen String-muodossa
     */
    public String getKoiranNimi() {
        return koiranNimi;
    }

    /**
     * Asettaa koiran nimen.
     * @param koiranNimi nimi, joka asetetaan koiralle
     */
    public void setKoiranNimi(String koiranNimi) {
        this.koiranNimi = koiranNimi;
    }

    /**
     * Hakee annetun arvon koiran painolle
     * @return palauttaa annetun painon double-muodossa
     */
    public double getKoiranPaino() {
        return koiranPaino;
    }

    /**
     * Asettaa koiran painon
     * @param koiranPaino paino, joka asetetaan koiralle
     */
    public void setKoiranPaino(double koiranPaino) {
        this.koiranPaino = koiranPaino;
    }

    /**
     * Hakee arvon koiran ruoan annokselle
     * @return palauttaa annetun annoksen double-muodossa
     */
    public double getAnnos() {
        return annos;
    }

    /**
     * Asettaa annokselle arvon
     * @param annos annoskoko, joka asetetaan
     */
    public void setAnnos(double annos) {
        this.annos = annos;
    }

    /**
     * Hakee annetun ajan arvon.
     * @return palauttaa annetun ajan LocalTime-muodossa
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Asettaa ajan
     * @param time aika, jolloin koira on ruokittu
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /** Hakee ja palauttaa tiedot.
     * @return palauttaa aterian tiedot merkkijonona
     */
    public abstract String getDetails();


}
