package com.example.projekti;
import java.util.ArrayList;
import java.util.List;

public class TiedostoHandler implements Tallenna{
    private static final String TIEDOSTON_NIMI = "ateriat.txt";

    @Override
    public void tallennaAteria(Ruoka ateria) {
//        try ((new FileWriter(TIEDOSTON_NIMI, true))) {
//            writer.write(ateria + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<String> lataaAteria() {
        List<String> ateriat = new ArrayList<>();
        //tähän try catch toiminto millä luetaan rivejä
//        try (){
//            String rivi;
//            while ((rivi = reader.readLine()) != null) {
//                ateriat.add(rivi);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return ateriat;
    }
}
