package mietverwaltung;

import java.io.Serializable;

public class Suchanfrage implements Serializable {

    private static final long serialVersionUID = -804315134610244602L;

    private int mitarbeiterID;
    private int kundenID;
    private double zimmeranzahl;
    private double fl�che;
    private double kosten;
    private double etage;
    private boolean balkon;
    private boolean fu�bodenheizung;
    private String aussicht;
    // private Gregorien aktuellesDatum;

    public Suchanfrage(final int mitarbeiterID, final int kundenID, final double such_zimmeranzahl, final double fl�che, final double kosten, final double such_etage, final boolean balkon, final boolean fu�bodenheizung, final String aussicht) {

        this.mitarbeiterID = mitarbeiterID;
        this.kundenID = kundenID;
        this.zimmeranzahl = such_zimmeranzahl;
        this.fl�che = fl�che;
        this.kosten = kosten;
        this.etage = such_etage;
        this.balkon = balkon;
        this.fu�bodenheizung = fu�bodenheizung;
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

    public double getFl�che() {
        return this.fl�che;
    }

    public void setFl�che(final double fl�che) {
        this.fl�che = fl�che;
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

    public boolean getFu�bodenheizung() {
        return this.fu�bodenheizung;
    }

    public void setFu�bodenheizung(final boolean fu�bodenheizung) {
        this.fu�bodenheizung = fu�bodenheizung;
    }

    public String getAussicht() {
        return this.aussicht;
    }

    public void setAussicht(final String aussicht) {
        this.aussicht = aussicht;
    }

}