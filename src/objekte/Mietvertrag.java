package objekte;

import java.io.Serializable;

import hilfsklassen.Datum;

public class Mietvertrag implements Serializable {

    private static final long serialVersionUID = -3908830402562090309L;

    private int mietvertragsID;
    private int wohnungsID;
    private int kundenID;
    private Datum mietBeginn;
    private Datum mietEnde;

    public Mietvertrag(final int mietvertragID, final int wohnungsID, final int kundenID, final int mitarbeiterID, final Datum mietBeginn, final Datum mietEnde) {
        this.mietvertragsID = mietvertragID;
        this.wohnungsID = wohnungsID;
        this.kundenID = kundenID;
        this.mietBeginn = mietBeginn;
        this.mietEnde = mietEnde;
    }

}
