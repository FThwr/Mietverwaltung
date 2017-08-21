package mietverwaltung;

public abstract class Kunde {

    protected int kundenID;
    protected String name;
    protected String vorname;
    protected Datum geburtsdatum;
    protected Adresse adresse;
    protected String email;
    protected String telefonnummer;
    protected String rolle;

    public Kunde(final int kundenID, final String name, final String vorname, final Datum geburtsdatum, final String email, final Adresse adresse, final String telefonnummer, final String rolle) {
        this.kundenID = kundenID;
        this.name = name;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
        this.adresse = adresse;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return String.format("Kunde: %nKunden-ID: %d%n Name: %s%n Vorname: %n%s Geburtdatum: %s&n Adresse: %s%n E-Mail: %s%n Telefonnummer: %s%n Rolle: %s%n", this.kundenID, this.name, this.vorname, this.geburtsdatum, this.adresse, this.email, this.telefonnummer, this.rolle);
    }

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(final int kundenID) {
        this.kundenID = kundenID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(final String vorname) {
        this.vorname = vorname;
    }

    public Datum getGeburtsdatum() {
        return this.geburtsdatum;
    }

    public void setGeburtsdatum(final Datum geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(final Adresse adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTelefonnummer() {
        return this.telefonnummer;
    }

    public void setTelefonnummer(final String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getRolle() {
        return this.rolle;
    }

    public void setRolle(final String rolle) {
        this.rolle = rolle;
    }

}
