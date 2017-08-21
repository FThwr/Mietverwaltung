package mietverwaltung;

import java.io.Serializable;

public class Mitarbeiter implements Serializable{
	
	private int mitarbeiterID;
	private String name;
	private String vorname;
	private String benutzername;
	private String passwort;
		
	public Mitarbeiter (int mitarbeiterID, String name, String vorname, String benutzername, String passwort) {
		this.mitarbeiterID = mitarbeiterID;
		this.name = name;
		this.passwort = passwort;
		this.vorname = vorname;
		this.benutzername = vorname.trim().substring(0, 1) + "." + name;
	}
	
	public Mitarbeiter (int mitarbeiterID, String name, String vorname, String passwort) {
		this.mitarbeiterID = mitarbeiterID;
		this.name = name;
		this.passwort = passwort;
		this.vorname = vorname;
		this.benutzername = vorname.trim().substring(0, 1) + "." + name;
	}
	
	public Mitarbeiter (int mitarbeiterID, String name, String vorname) {
		this.mitarbeiterID = mitarbeiterID;
		this.name = name;
		this.vorname = vorname;
	}

//	@Override
//	public String toString() {
//		return "Mitarbeiter: Name: " + name + "\nVorname: " + vorname + "\nBenutzername: " + benutzername + "\nPasswort: "
//				+ passwort;
//	}
	
	@Override
	public String toString() {
		return mitarbeiterID + " " +  name + " " +  vorname;
	}
	
	public int getMitarbeiterID() {
		return mitarbeiterID;
	}

	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
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

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	
}

