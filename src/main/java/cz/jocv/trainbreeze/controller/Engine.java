package cz.jocv.trainbreeze.controller;

import cz.jocv.trainbreeze.datamodel.InKarta;
import cz.jocv.trainbreeze.datamodel.Trasa;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private static int rocne;
    private static Engine engine = new Engine();

    private Engine() {
    }

    public static Engine getInstance() {
        return engine;
    }

    public static int getRocne() {
        return rocne;
    }

    public InKarta spoctiVysledek(List<Trasa> trasy){
        int celkovaCena = 0;

        for (Trasa t: trasy){
            int pocetKm = t.getPocetKilometru();
            int pocetJizd = t.getPocetJizd();
            double cenaZaKm;
            double cenaJizd;
            if (pocetKm < 50){
                cenaZaKm = 1.8;
            } else if (pocetKm < 100){
                cenaZaKm = 1.5;
            } else if (pocetKm < 200){
                cenaZaKm = 1.3;
            } else {
                cenaZaKm = 1.2;
            }
            cenaJizd = cenaZaKm * pocetKm * pocetJizd;
            celkovaCena += cenaJizd;
        }

        double cenaZaRok = celkovaCena * 52;
        rocne = (int) cenaZaRok;
        ArrayList<InKarta> inKarty = new ArrayList<>();
        inKarty.add(new InKarta(0,"IN0",0,0));
        inKarty.add(new InKarta(450,"IN25",25,(int) (cenaZaRok * 0.25 - 490)));
        inKarty.add(new InKarta(2990,"IN50",50,(int) (cenaZaRok * 0.5 - 2990)));
        inKarty.add(new InKarta(19990,"IN100",100,(int) (cenaZaRok - 19900)));

        InKarta inkartaNejvetsiUspora = inKarty.get(0);

        for(InKarta i: inKarty){
            if (i.getPenezinaUspora() > inkartaNejvetsiUspora.getPenezinaUspora()){
                inkartaNejvetsiUspora = i;
            }
        }
        return inkartaNejvetsiUspora;
    }


}
