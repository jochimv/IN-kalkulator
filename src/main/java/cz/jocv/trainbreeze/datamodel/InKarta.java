package cz.jocv.trainbreeze.datamodel;

public class InKarta {
    private int cenaZaRok;
    private String typ;
    private int procentualniUspora;
    private int penezinaUspora;

    public InKarta(int cenaZaRok, String typ, int procentualniUspora, int penezinaUspora) {
        this.cenaZaRok = cenaZaRok;
        this.typ = typ;
        this.procentualniUspora = procentualniUspora;
        this.penezinaUspora = penezinaUspora;
    }

    public int getCenaZaRok() {
        return cenaZaRok;
    }

    public String getTyp() {
        return typ;
    }

    public int getProcentualniUspora() {
        return procentualniUspora;
    }

    public int getPenezinaUspora() {
        return penezinaUspora;
    }
}
