package objekte;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;

public class Mieter extends Kunde {

	private String rolle;
	
	public Mieter(int kundenID, String name, String vorname, Datum geburtsdatum, Adresse adresse, String email,
			String telefonnummer) {
		super(kundenID, name, vorname, geburtsdatum, adresse, email, telefonnummer);
		this.setRolle("Mieter");
	}
	
	@Override
	public String toString() {
		return "Mieter: \nKunden-ID:" + kundenID + "\nName: " + name + "\nVorname: " + vorname + "\nGeburtsdatum: "
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
