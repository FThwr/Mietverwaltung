package objekte;

public class Mitarbeiter {
	
	private String passwort;
	private String name;
	
	public Mitarbeiter (String passwort, String name) {
		this.passwort = passwort;
		this.name = name;
	}
	
	public Mitarbeiter (String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
