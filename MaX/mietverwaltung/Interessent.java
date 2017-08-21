package mietverwaltung;

import java.io.Serializable;

public class Interessent extends Kunde implements Serializable{
	
	public Interessent (int kundenID, String name, String vorname, Datum geburtsdatum, String email, Adresse adresse, String telefonnummer, String rolle) {
		super(kundenID, name, vorname, geburtsdatum, email, adresse, telefonnummer, rolle);
	}

	@Override
	public String toString() {
		return "Interessent: \nInteressenten-ID:" + kundenID 
				+ "\nName: " + name 
				+ "\nVorname: " + vorname 
				+ "\nGeburtsdatum: " + geburtsdatum.toString() 
				+ "\nE-Mail: " + email 
				+ "\nAdresse: " + adresse.toString() 
				+ "\nTelefonnummer: " + telefonnummer 
				+ "\nRolle: " + rolle;
	}
	
	@Override
	public void display() {
		System.out.println(this.toString());
	}
}

