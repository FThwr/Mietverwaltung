package objekte;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;

public class Interessent extends Kunde {

    private static final long serialVersionUID = -5060255053168345408L;

    public Interessent(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final Adresse adresse, final String email, final String telefonnummer, final String rolle) {
        super(kundenID, name, vorname, geburtsdatum, email, adresse, telefonnummer, rolle);
    }

    @Override
    public String toString() {
        return "Interessent: \nKunden-ID:" + this.kundenID + "\nName: " + this.name + "\nVorname: " + this.vorname + "\nGeburtsdatum: " + this.geburtsdatum.toString() + "\nAdresse: " + this.adresse.toString() + "\nE-Mail: " + this.email + "\nTelefonnummer: " + this.telefonnummer + "\nRolle: " + this.rolle;
    }

}
