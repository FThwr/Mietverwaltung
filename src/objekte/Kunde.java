package objekte;

import hilfsklassen.*;

public abstract class Kunde {

	protected int kundenID;
	protected String name;
	protected String vorname;
	protected Datum geburtsdatum;
	protected Adresse adresse;
	protected String email;
	protected String telefonnummer;
	
	public Kunde(int kundenID, String name, String vorname, Datum geburtsdatum, Adresse adresse, String email, String telefonnummer) {
		this.kundenID = kundenID;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.adresse = adresse;
		this.email = email;
		this.telefonnummer = telefonnummer;
	}


	@Override
	public String toString() {
		return "Kunde: \nKunden-ID:" + kundenID + "\nName: " + name + "\nVorname: " + vorname + "\nGeburtsdatum: "
				+ geburtsdatum.toString() + "\nAdresse: " + adresse.toString() + "\nE-Mail: " + email + "\nTelefonnummer: " + telefonnummer;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public int getKundenID() {
		return kundenID;
	}


	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Datum getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Datum geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
}
