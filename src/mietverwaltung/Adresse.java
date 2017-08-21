package mietverwaltung;

import java.io.Serializable;

public class Adresse implements Serializable {

    private static final long serialVersionUID = -1808836307904995394L;

    private String strasse;
    private int hausnummer;
    private int plz;
    private String stadt;

    public Adresse(final String strasse, final int hausnummer, final int plz, final String stadt) {
        this.setStrasse(strasse);
        this.setHausnummer(hausnummer);
        this.setPlz(plz);
        this.setStadt(stadt);
    }

    @Override
    public String toString() {
        return (this.strasse + " " + this.hausnummer + " " + this.plz + " " + this.stadt);
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String getStrasse() {
        return this.strasse;
    }

    public void setStrasse(final String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return this.hausnummer;
    }

    public void setHausnummer(final int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPlz() {
        return this.plz;
    }

    public void setPlz(final int plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return this.stadt;
    }

    public void setStadt(final String stadt) {
        this.stadt = stadt;
    }

}
