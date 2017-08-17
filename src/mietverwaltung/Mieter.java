package mietverwaltung;

public class Mieter extends Kunde {

    public Mieter(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final int wohnungsnummer, final String email, final Adresse adresse, final String telefonnummer, final String rolle) {
        super(kundenID, name, vorname, geburtsdatum, wohnungsnummer, email, adresse, telefonnummer, rolle);
    }

    @Override
    public String toString() {
        return "Mieter: \nMieter-ID:" + this.kundenID + "\nName: " + this.name + "\nVorname: " + this.vorname + "\nGeburtsdatum: " + this.geburtsdatum.toString() + "\nAdresse: " + this.adresse.toString() + "\nE-Mail: " + this.email + "\nTelefonnummer: " + this.telefonnummer + "\nRolle: " + this.rolle;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }
}
