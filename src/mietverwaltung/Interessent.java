package mietverwaltung;

public class Interessent extends Kunde {

    public Interessent(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final String email, final Adresse adresse, final String telefonnummer, final String rolle) {
        super(kundenID, name, vorname, geburtsdatum, email, adresse, telefonnummer, rolle);
    }

    @Override
    public String toString() {
        return "Interessent: \nInteressenten-ID:" + this.kundenID + "\nName: " + this.name + "\nVorname: " + this.vorname + "\nGeburtsdatum: " + this.geburtsdatum.toString() + "\nE-Mail: " + this.email + "\nAdresse: " + this.adresse.toString() + "\nTelefonnummer: " + this.telefonnummer + "\nRolle: " + this.rolle;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }
}
