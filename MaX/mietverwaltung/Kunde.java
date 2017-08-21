package mietverwaltung;

import java.io.Serializable;

public abstract class Kunde implements Serializable{
	
	protected int kundenID;
	protected String name;
	protected String vorname;
	protected Datum geburtsdatum;
	protected int wohnungsnummer; 
	protected Adresse adresse;
	protected String email;
	protected String telefonnummer;
	protected String rolle; 
	
	public Kunde (int kundenID, String name, String vorname, Datum geburtsdatum, int wohnungsnummer, String email, Adresse adresse, String telefonnummer, String rolle) {
		this.kundenID = kundenID;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.wohnungsnummer = wohnungsnummer;
		this.adresse = adresse;
		this.email = email;
		this.telefonnummer = telefonnummer;
		this.rolle = rolle;
	}
	
	public Kunde (int kundenID, String name, String vorname, Datum geburtsdatum, String email, Adresse adresse, String telefonnummer, String rolle) {
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
		return "Kunde: \nKunden-ID:" + kundenID + "\nName: " + name + "\nVorname: " + vorname + "\nGeburtsdatum: "
				+ geburtsdatum.toString() + "\nWohnungsnummer: " + wohnungsnummer + "\nAdresse: " + adresse.toString() + "\nE-Mail: " + email + "\nTelefonnummer: " + telefonnummer + "\nRolle: " + rolle;
	}

	public void display() {
		System.out.println(this.toString());
	}

	public int getWohnungsnummer() {
		return wohnungsnummer;
	}

	public void setWohnungsnummer(int wohnungsnummer) {
		this.wohnungsnummer = wohnungsnummer;
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

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

}
