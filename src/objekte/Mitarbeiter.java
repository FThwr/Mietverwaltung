package objekte;

public class Mitarbeiter {
	
	private String name;
	private String vorname;
	private String benutzername;
	private String passwort;
	
	
	public Mitarbeiter (String name, String vorname, String passwort) {
		this.name = name;
		this.passwort = passwort;
		this.benutzername = vorname.trim().substring(0, 1) + "." + name;
	}
	
	public Mitarbeiter (String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}

	@Override
	public String toString() {
		return "Mitarbeiter: Name: " + name + "\nVorname: " + vorname + "\nBenutzername: " + benutzername + "\nPasswort: "
				+ passwort;
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
