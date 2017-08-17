package mietverwaltung;

public class Handwerkerauftrag {

    private String auftragsID;
    private int wohnungsID;
    private int mitarbeiterID;
    private String m�ngelbeschreibung;
    private String status;
    private Datum eingangsdatum;
    private Datum fertigstellungsDatum;

    public Handwerkerauftrag(final String auftragsID, final int wohnungsID, final int mitarbeiterID, final String m�ngelbeschreibung, final String status, final Datum eingangsdatum, final Datum fertigstellungsDatum) {
        this.auftragsID = auftragsID;
        this.wohnungsID = wohnungsID;
        this.mitarbeiterID = mitarbeiterID;
        this.m�ngelbeschreibung = m�ngelbeschreibung;
        this.status = status;
        this.eingangsdatum = eingangsdatum;
        this.fertigstellungsDatum = fertigstellungsDatum;
    }

    public Handwerkerauftrag(final String auftragsID) {
        this.auftragsID = auftragsID;
    }

    public String getAuftragsID() {
        return this.auftragsID;
    }

    public void setAuftragsID(final String auftragsID) {
        this.auftragsID = auftragsID;
    }

    public String getM�ngelbeschreibung() {
        return this.m�ngelbeschreibung;
    }

    public void setM�ngelbeschreibung(final String m�ngelbeschreibung) {
        this.m�ngelbeschreibung = m�ngelbeschreibung;
    }

    public int getWohnungsID() {
        return this.wohnungsID;
    }

    public void setWohnungsID(final int wohnungsID) {
        this.wohnungsID = wohnungsID;
    }

    public int getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    public void setMitarbeiterID(final int mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Datum getEingangsdatum() {
        return this.eingangsdatum;
    }

    public void setEingangsdatum(final Datum eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }

    public Datum getFertigstellungsDatum() {
        return this.fertigstellungsDatum;
    }

    public void setFertigstellungsDatum(final Datum fertigstellungsDatum) {
        this.fertigstellungsDatum = fertigstellungsDatum;
    }

}
