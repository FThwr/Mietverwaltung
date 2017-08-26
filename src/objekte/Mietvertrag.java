package objekte;

import java.io.Serializable;

import hilfsklassen.Datum;

public class Mietvertrag implements Serializable {

    private static final long serialVersionUID = -3908830402562090309L;

    private int mietvertragsID;
    private int wohnungsID;
    private int mitarbeiterID;
    private int kundenID;
    private Datum mietBeginn;
    private Datum mietEnde;
    private String status;

    public Mietvertrag(final int mietvertragID, final int wohnungsID, final int kundenID, final int mitarbeiterID, final Datum mietBeginn, final Datum mietEnde, final String status) {
        this.mietvertragsID = mietvertragID;
        this.wohnungsID = wohnungsID;
        this.kundenID = kundenID;
        this.mitarbeiterID = mitarbeiterID;
        this.mietBeginn = mietBeginn;
        this.mietEnde = mietEnde;
        this.status = status;
    }

    public int getMietvertragsID() {
        return this.mietvertragsID;
    }

    public void setMietvertragsID(final int mietvertragsID) {
        this.mietvertragsID = mietvertragsID;
    }

    public int getWohnungsID() {
        return this.wohnungsID;
    }

    public void setWohnungsID(final int wohnungsID) {
        this.wohnungsID = wohnungsID;
    }

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(final int kundenID) {
        this.kundenID = kundenID;
    }

    public Datum getMietBeginn() {
        return this.mietBeginn;
    }

    public void setMietBeginn(final Datum mietBeginn) {
        this.mietBeginn = mietBeginn;
    }

    public Datum getMietEnde() {
        return this.mietEnde;
    }

    public void setMietEnde(final Datum mietEnde) {
        this.mietEnde = mietEnde;
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

}
