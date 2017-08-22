package mietverwaltung;

import java.io.Serializable;

public class Suchanfrage implements Serializable {

    private static final long serialVersionUID = -804315134610244602L;

    private int mitarbeiterID;
    private int kundenID;
    private double zimmeranzahl;
    private double fläche;
    private double kosten;
    private double etage;
    private boolean balkon;
    private boolean fußbodenheizung;
    private String aussicht;
    // private Gregorien aktuellesDatum;

    public Suchanfrage(final int mitarbeiterID, final int kundenID, final double such_zimmeranzahl, final double fläche, final double kosten, final double such_etage, final boolean balkon, final boolean fußbodenheizung, final String aussicht) {

        this.mitarbeiterID = mitarbeiterID;
        this.kundenID = kundenID;
        this.zimmeranzahl = such_zimmeranzahl;
        this.fläche = fläche;
        this.kosten = kosten;
        this.etage = such_etage;
        this.balkon = balkon;
        this.fußbodenheizung = fußbodenheizung;
        this.aussicht = aussicht;
        //     this.aktuellesDatum = this.aktuellesDatum;
    }

    //    public Gregorien getAktuellesDatum() {
    //        return this.aktuellesDatum;
    //    }
    //
    //    public void setAktuellesDatum(final Gregorien aktuellesDatum) {
    //        this.aktuellesDatum = aktuellesDatum;
    //    }

    public int getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    public void setMitarbeiterID(final int mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(final int kundenID) {
        this.kundenID = kundenID;
    }

    public double getZimmeranzahl() {
        return this.zimmeranzahl;
    }

    public void setZimmeranzahl(final double zimmeranzahl) {
        this.zimmeranzahl = zimmeranzahl;
    }

    public double getFläche() {
        return this.fläche;
    }

    public void setFläche(final double fläche) {
        this.fläche = fläche;
    }

    public double getKosten() {
        return this.kosten;
    }

    public void setKosten(final double kosten) {
        this.kosten = kosten;
    }

    public double getEtage() {
        return this.etage;
    }

    public void setEtage(final double etage) {
        this.etage = etage;
    }

    public boolean getBalkon() {
        return this.balkon;
    }

    public void setBalkon(final boolean balkon) {
        this.balkon = balkon;
    }

    public boolean getFußbodenheizung() {
        return this.fußbodenheizung;
    }

    public void setFußbodenheizung(final boolean fußbodenheizung) {
        this.fußbodenheizung = fußbodenheizung;
    }

    public String getAussicht() {
        return this.aussicht;
    }

    public void setAussicht(final String aussicht) {
        this.aussicht = aussicht;
    }

}