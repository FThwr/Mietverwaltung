package hilfsklassen;

public class Adresse {

	private String strasse;
	private int hausnummer;
	private int plz;
	private String stadt;
	
	public Adresse(String strasse, int hausnummer, int plz, String stadt) {
		this.setStrasse(strasse);
		this.setHausnummer(hausnummer);
		this.setPlz(plz);
		this.setStadt(stadt);
	}
	
	public String toString() {
		return (strasse+" "+hausnummer+"\n"+plz+" "+stadt);
	}
	
	public void display() {
		System.out.println(this.toString());
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	
}
