package com.example.projekti;
import com.example.projekti.Ruoka;

import java.util.List;

/**
 * Tallenna-rajapinta tarjoaa metodit, joiden avulla Ruoka-olioiden tietoja
 * voidaan tallentaa ja ladata tiedostosta. Tämä soveltuu käytettäväksi
 * tilanteissa, joissa tarvitaan tietojen pysyväistallennusta ja
 * uudelleenkäyttöä ohjelman seuraavien ajokertojen aikana.
 */
public interface Tallenna {

    /**
     * Tallentaa annetun Ruoka-olion tiedot tiedostoon.
     * @param ateria Ruoka-olio, joka sisältää tallennettavat tiedot,
     *               kuten koiran nimi, ruoka-annoksen koko,
     *               koiran paino ja ruoan antoaika.
     */
    void tallennaAteria(Ruoka ateria);

    /**
     * Lataa tiedostosta tallennetut Ruoka-oliot ja palauttaa ne listana.
     * @return lista Ruoka-olioista, jotka on ladattu tiedostosta
     */
    List<Ruoka> lataaAteria();
}
