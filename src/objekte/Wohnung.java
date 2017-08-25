package objekte;

import java.io.Serializable;

import hilfsklassen.Adresse;

public class Wohnung implements Serializable {

    private static final long serialVersionUID = -711561699997322789L;

    private int wohnungsID;
    private int zimmeranzahl;
    private double fl‰che;
    private double kosten;
    private int etage;
    private boolean balkon;
    private boolean fuﬂbodenheizung;
    private String aussicht;
    private Adresse adresse;
    private String status;
    private String letztesRenovierungsdatum;
    private int renovierungsanzahl;
    private String letzeRenovierung_Details;
    //	private String handwerkerauftrag;
    private Mitarbeiter zugeordneterMitarbeiter;

    public Wohnung(final int wohnungsID, final int zimmeranzahl, final double fl‰che, final double kosten, final int etage, final boolean balkon, final boolean fuﬂbodenheizung, final String aussicht, final Adresse adresse, final String status, final String letztesRenovierungsdatum, final int renovierungsanzahl, final String letzeRenovierung_Details, final Mitarbeiter zugeordneterMitarbeiter) {
        this.wohnungsID = wohnungsID;
        this.zimmeranzahl = zimmeranzahl;
        this.fl‰che = fl‰che;
        this.kosten = kosten;
        this.etage = etage;
        this.balkon = balkon;
        this.fuﬂbodenheizung = fuﬂbodenheizung;
        this.aussicht = aussicht;
        this.adresse = adresse;
        this.status = status;
        this.letztesRenovierungsdatum = letztesRenovierungsdatum;
        this.renovierungsanzahl = renovierungsanzahl;
        this.letzeRenovierung_Details = letzeRenovierung_Details;
        this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
    }

    public int getWohnungsID() {
        return this.wohnungsID;
    }

    public void setWohnungsID(final int wohnungsID) {
        this.wohnungsID = wohnungsID;
    }

    public int getZimmeranzahl() {
        return this.zimmeranzahl;
    }

    public void setZimmeranzahl(final int zimmeranzahl) {
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

    public int getEtage() {
        return this.etage;
    }

    public void setEtage(final int etage) {
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

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(final Adresse adresse) {
        this.adresse = adresse;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getLetztesRenovierungsdatum() {
        return this.letztesRenovierungsdatum;
    }

    public void setLetztesRenovierungsdatum(final String letztesRenovierungsdatum) {
        this.letztesRenovierungsdatum = letztesRenovierungsdatum;
    }

    public int getRenovierungsanzahl() {
        return this.renovierungsanzahl;
    }

    public void setRenovierungsanzahl(final int renovierungsanzahl) {
        this.renovierungsanzahl = renovierungsanzahl;
    }

    public String getLetzeRenovierung_Details() {
        return this.letzeRenovierung_Details;
    }

    public void setLetzeRenovierung_Details(final String letzeRenovierung_Details) {
        this.letzeRenovierung_Details = letzeRenovierung_Details;
    }

    public Mitarbeiter getZugeordneterMitarbeiter() {
        return this.zugeordneterMitarbeiter;
    }

    public void setZugeordneterMitarbeiter(final Mitarbeiter zugeordneterMitarbeiter) {
        this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
    }

}