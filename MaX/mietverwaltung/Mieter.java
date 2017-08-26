package mietverwaltung;

import java.io.Serializable;

public class Mieter extends Kunde implements Serializable{
	
	public Mieter (int kundenID, String name, String vorname, Datum geburtsdatum, int wohnungsnummer, String email, Adresse adresse, String telefonnummer, String rolle) {
		super(kundenID, name, vorname, geburtsdatum, wohnungsnummer, email, adresse, telefonnummer, rolle);
		
	}

	@Override
	public String toString() {
		return "Mieter: \nMieter-ID:" + kundenID 
				+ "\nName: " + name 
				+ "\nVorname: " + vorname 
				+ "\nGeburtsdatum: " + geburtsdatum.toString() 
				+ "\nAdresse: " + adresse.toString() 
				+ "\nE-Mail: " + email + "\nTelefonnummer: " 
				+ telefonnummer + "\nRolle: " + rolle;
	}
	
	@Override
	public void display() {
		System.out.println(this.toString());
	}
}
