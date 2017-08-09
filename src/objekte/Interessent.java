package objekte;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;

public class Interessent extends Kunde {

	private String rolle;
	
	public Interessent(int kundenID, String name, String vorname, Datum geburtsdatum, int wohnungsnummer, Adresse adresse, String email,
			String telefonnummer) {
		super(kundenID, name, vorname, geburtsdatum, wohnungsnummer, adresse, email, telefonnummer);
		this.setRolle("Interessent");
	}

	@Override
	public String toString() {
		return "Interessent: \nKunden-ID:" + kundenID + "\nName: " + name + "\nVorname: " + vorname + "\nGeburtsdatum: "
				+ geburtsdatum.toString() + "\nAdresse: " + adresse.toString() + "\nE-Mail: " + email + "\nTelefonnummer: " + telefonnummer + "\nRolle: " + rolle;
	}
	
	@Override
	public void display() {
		System.out.println(this.toString());
	}
	
	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}


}
