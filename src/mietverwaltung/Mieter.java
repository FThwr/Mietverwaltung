package mietverwaltung;

public class Mieter extends Kunde {

    private static final long serialVersionUID = 3620317998156570808L;

    protected int wohnungsnummer;

    public Mieter(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final int wohnungsnummer, final String email, final Adresse adresse, final String telefonnummer, final String rolle) {
        super(kundenID, name, vorname, geburtsdatum, email, adresse, telefonnummer, rolle);
        this.wohnungsnummer = wohnungsnummer;
    }

    //    @Override
    //    public String toString() {
    //        return "Mieter: \nMieter-ID:" + this.kundenID + "\nName: " + this.name + "\nVorname: " + this.vorname + "\nGeburtsdatum: " + this.geburtsdatum.toString() + "\nAdresse: " + this.adresse.toString() + "\nE-Mail: " + this.email + "\nTelefonnummer: " + this.telefonnummer + "\nRolle: " + this.rolle;
    //    }

    @Override
    public String toString() {
        return String.format("Mieter %nMieter-ID: %d%n Name: %s%n Vorname: %n%s Geburtdatum: %s%n Wohnungsnummer: %s%n Adresse: %s%n E-Mail: %s%n Telefonnummer: %s%n Rolle: %s%n", this.kundenID, this.name, this.vorname, this.geburtsdatum, this.wohnungsnummer, this.adresse, this.email, this.telefonnummer, this.rolle);
    }

    public int getWohnungsnummer() {
        return this.wohnungsnummer;
    }

    public void setWohnungsnummer(final int wohnungsnummer) {
        this.wohnungsnummer = wohnungsnummer;
    }
}
