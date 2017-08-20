package mietverwaltung;

public class Interessent extends Kunde {

    public Interessent(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final String email, final Adresse adresse, final String telefonnummer, final String rolle) {
        super(kundenID, name, vorname, geburtsdatum, email, adresse, telefonnummer, rolle);
    }

    //    @Override
    //    public String toString() {
    //        //return "Interessent: \nInteressenten-ID:"  + this.kundenID + "\nName: " + this.name + "\nVorname: " + this.vorname + "\nGeburtsdatum: " + this.geburtsdatum.toString() + "\nE-Mail: " + this.email + "\nAdresse: " + this.adresse.toString() + "\nTelefonnummer: " + this.telefonnummer + "\nRolle: " + this.rolle;
    //        return String.format("Interessent:%nInteressenten-ID: %d%nName: %s%nVorname: %s%nGeburtsdatum: %s%n E-Mail: %s%n Adresse: %s%n Telefonnummer: %s%n Rolle: %s", this.kundenID, this.name, this.vorname, this.geburtsdatum, this.email, this.adresse, this.telefonnummer, this.rolle);
    //    }
}