package objekte;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;

public class Interessent extends Kunde {

    private static final long serialVersionUID = -5060255053168345408L;

    private String rolle;

    public Interessent(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final Adresse adresse, final String email, final String telefonnummer) {
        super(kundenID, name, vorname, geburtsdatum, adresse, email, telefonnummer);
        this.setRolle("Interessent");
    }

    //	@Override
    //	public String toString() {
    //		return "Interessent: \nKunden-ID:" + kundenID + "\nName: " + name + "\nVorname: " + vorname + "\nGeburtsdatum: "
    //				+ geburtsdatum.toString() + "\nAdresse: " + adresse.toString() + "\nE-Mail: " + email + "\nTelefonnummer: " + telefonnummer + "\nRolle: " + rolle;
    //	}

    public String getRolle() {
        return this.rolle;
    }

    public void setRolle(final String rolle) {
        this.rolle = rolle;
    }

}
