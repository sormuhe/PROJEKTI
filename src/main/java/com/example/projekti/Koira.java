package com.example.projekti;

/***
 * Tätä luokkaa käytetään koiran tietojen käsittelyyn,
 * kuten nimi ja paino
 * @author Heidi Sormunen
 *
 */

public class Koira {

        /**
         * koiran nimi ja rotu merkkijonona
         */
        private String nimi;
        private String rotu;

        /**
         * koiran piano desimaalilukuna
         */
        private double paino;

    /**
     * Koira perustiedoilla
     * @param nimi String nimi
     * @param rotu String rotu
     * @param paino double paino
     */

    public Koira(String nimi, String rotu, double paino) {
            this.nimi = nimi;
            this.rotu = rotu;
            this.paino = paino;
        }

        public String getNimi() {
            return nimi;
        }

        public String getRotu() {
            return rotu;
        }

        public double getPaino() {
            return paino;
        }

}
