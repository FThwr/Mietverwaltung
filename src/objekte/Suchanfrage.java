package objekte;

import java.io.Serializable;

public class Suchanfrage implements Serializable {

    private static final long serialVersionUID = -3929758526444227802L;
    private int mitarbeiterID;
    private int kundenID;
    private double zimmeranzahl;
    private char relaZimmeranzahl;
    private double fl‰che;
    private char relaFl‰che;
    private double kosten;
    private char relaKosten;
    private double etage;
    private char relaEtage;
    private boolean balkon;
    private boolean fuﬂbodenheizung;
    private String aussicht;

    public Suchanfrage(final int mitarbeiterID, final int kundenID, final char relaZimmeranzahl, final double such_zimmeranzahl, final char relaFl‰che, final double fl‰che, final char relaKosten, final double kosten, final char relaEtage, final double such_etage, final boolean balkon, final boolean fuﬂbodenheizung, final String aussicht) {

        this.mitarbeiterID = mitarbeiterID;
        this.kundenID = kundenID;
        this.zimmeranzahl = such_zimmeranzahl;
        this.relaZimmeranzahl = relaZimmeranzahl;
        this.fl‰che = fl‰che;
        this.relaFl‰che = relaFl‰che;
        this.kosten = kosten;
        this.relaKosten = relaKosten;
        this.etage = such_etage;
        this.relaEtage = relaEtage;
        this.balkon = balkon;
        this.fuﬂbodenheizung = fuﬂbodenheizung;
        this.aussicht = aussicht;
    }

    public char getRelaZimmeranzahl() {
        return this.relaZimmeranzahl;
    }

    public void setRelaZimmeranzahl(final char relaZimmeranzahl) {
        this.relaZimmeranzahl = relaZimmeranzahl;
    }

    public char getRelaFl‰che() {
        return this.relaFl‰che;
    }

    public void setRelaFl‰che(final char relaFl‰che) {
        this.relaFl‰che = relaFl‰che;
    }

    public char getRelaKosten() {
        return this.relaKosten;
    }

    public void setRelaKosten(final char relaKosten) {
        this.relaKosten = relaKosten;
    }

    public char getRelaEtage() {
        return this.relaEtage;
    }

    public void setRelaEtage(final char relaEtage) {
        this.relaEtage = relaEtage;
    }

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

    public double getFl‰che() {
        return this.fl‰che;
    }

    public void setFl‰che(final double fl‰che) {
        this.fl‰che = fl‰che;
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

    public boolean getFuﬂbodenheizung() {
        return this.fuﬂbodenheizung;
    }

    public void setFuﬂbodenheizung(final boolean fuﬂbodenheizung) {
        this.fuﬂbodenheizung = fuﬂbodenheizung;
    }

    public String getAussicht() {
        return this.aussicht;
    }

    public void setAussicht(final String aussicht) {
        this.aussicht = aussicht;
    }
}
