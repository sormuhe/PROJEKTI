package com.example.projekti;
import java.time.LocalTime;

abstract class Ruoka {
    private String ruoanNimi;
    private double annos;
    private double koiranPaino;
    private LocalTime time;
    private String koiranNimi;


    public Ruoka(String koiranNimi, double annos, double koiranPaino, LocalTime time) {
        this.koiranNimi = koiranNimi;
        this.annos = annos;
        this.koiranPaino = koiranPaino;
        this.time = time;
    }

    public String getRuoanNimi() {
        return ruoanNimi;
    }

    public void setRuoanNimi(String ruoanNimi) {
        this.ruoanNimi = ruoanNimi;
    }

    public double getKoiranPaino() {
        return koiranPaino;
    }

    public void setKoiranPaino(double koiranPaino) {
        this.koiranPaino = koiranPaino;
    }

    public double getAnnos() {
        return annos;
    }

    public void setAnnos(double annos) {
        this.annos = annos;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getKoiranNimi() {
        return koiranNimi;
    }

    public void setKoiranNimi(String koiranNimi) {
        this.koiranNimi = koiranNimi;
    }

    public abstract String getDetails();
}
