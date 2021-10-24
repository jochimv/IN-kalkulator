package cz.jocv.trainbreeze.datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Trasa {
    private SimpleStringProperty pocatecniStanice;
    private SimpleStringProperty cilovaStanice;
    private SimpleIntegerProperty pocetKilometru;
    private SimpleIntegerProperty pocetJizd;

    public Trasa(String pocatecniStanice, String cilovaStanice, Integer pocetKilometru, Integer pocetJizd) {
        this.pocatecniStanice = new SimpleStringProperty(pocatecniStanice);
        this.cilovaStanice = new SimpleStringProperty(cilovaStanice);
        this.pocetKilometru = new SimpleIntegerProperty(pocetKilometru);
        this.pocetJizd = new SimpleIntegerProperty(pocetJizd);
    }

    public String getPocatecniStanice() {
        return pocatecniStanice.get();
    }

    public String getCilovaStanice() {
        return cilovaStanice.get();
    }

    public int getPocetKilometru() {
        return pocetKilometru.get();
    }

    public int getPocetJizd() {
        return pocetJizd.get();
    }

    public void setPocatecniStanice(String pocatecniStanice) {
        this.pocatecniStanice.set(pocatecniStanice);
    }

    public void setCilovaStanice(String cilovaStanice) {
        this.cilovaStanice.set(cilovaStanice);
    }

    public void setPocetKilometru(int pocetKilometru) {
        this.pocetKilometru.set(pocetKilometru);
    }

    public void setPocetJizd(int pocetJizd) {
        this.pocetJizd.set(pocetJizd);
    }
}
