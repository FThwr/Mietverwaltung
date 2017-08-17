package mietverwaltung;

public class Mietvertrag {

    private String mietvertragID;
    private int wohnungsID;
    private int kundenID;
    private int mitarbeiterID;
    private Datum mietbeginn;
    private Datum mietende;

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

    public int getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    public void setMitarbeiterID(final int mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }

    public Datum getMietbeginn() {
        return this.mietbeginn;
    }

    public void setMietbeginn(final Datum mietbeginn) {
        this.mietbeginn = mietbeginn;
    }

    public Datum getMietende() {
        return this.mietende;
    }

    public void setMietende(final Datum mietende) {
        this.mietende = mietende;
    }

    public String getMietvertragID() {
        return this.mietvertragID;
    }

    public void setMietvertragID(final String mietvertragID) {
        this.mietvertragID = mietvertragID;
    }

    public Mietvertrag(final String mietvertragID, final int wohnungsID, final int kundenID, final int mitarbeiterID, final Datum mietbeginn, final Datum mietende) {

        this.mietvertragID = mietvertragID;
        this.wohnungsID = wohnungsID;
        this.kundenID = kundenID;
        this.mitarbeiterID = mitarbeiterID;
        this.mietbeginn = mietbeginn;
        this.mietende = mietende;
    }

}
