package all;

public class Wohnung {
	
	private int wohnungsID;
	private int zimmeranzahl;
	private double fl‰che;
	private double kosten;
	private int etage;
	private boolean balkon;
	private boolean fuﬂbodenheizung;
	private String aussicht;
	private String adresse;
	private String status;
	private String letztesRenovierungsdatum;
	private int renovierungsanzahl;
	private String letzeRenovierung_Details;
//	private String handwerkerauftrag;
	private Mitarbeiter zugeordneterMitarbeiter;
	
	
	public Wohnung(int wohnungsID, int zimmeranzahl, double fl‰che, double kosten, int etage, boolean balkon,boolean fuﬂbodenheizung, String aussicht, String adresse, String status, 
			String letztesRenovierungsdatum, int renovierungsanzahl, String letzeRenovierung_Details, Mitarbeiter zugeordneterMitarbeiter) {
		this.wohnungsID = wohnungsID;
		this.zimmeranzahl = zimmeranzahl;
		this.fl‰che = fl‰che;
		this.kosten = kosten;
		this.etage = etage;
		this.balkon = balkon;
		this.fuﬂbodenheizung = fuﬂbodenheizung;
		this.aussicht = aussicht;
		this.adresse = adresse;
		this.status = status;
		this.letztesRenovierungsdatum = letztesRenovierungsdatum;
		this.renovierungsanzahl = renovierungsanzahl;
		this.letzeRenovierung_Details = letzeRenovierung_Details;
		this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
	}


	public int getWohnungsID() {
		return wohnungsID;
	}


	public void setWohnungsID(int wohnungsID) {
		this.wohnungsID = wohnungsID;
	}


	public int getZimmeranzahl() {
		return zimmeranzahl;
	}


	public void setZimmeranzahl(int zimmeranzahl) {
		this.zimmeranzahl = zimmeranzahl;
	}


	public double getFl‰che() {
		return fl‰che;
	}


	public void setFl‰che(double fl‰che) {
		this.fl‰che = fl‰che;
	}


	public double getKosten() {
		return kosten;
	}


	public void setKosten(double kosten) {
		this.kosten = kosten;
	}


	public int getEtage() {
		return etage;
	}


	public void setEtage(int etage) {
		this.etage = etage;
	}


	public boolean isBalkon() {
		return balkon;
	}


	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}


	public boolean isFuﬂbodenheizung() {
		return fuﬂbodenheizung;
	}


	public void setFuﬂbodenheizung(boolean fuﬂbodenheizung) {
		this.fuﬂbodenheizung = fuﬂbodenheizung;
	}


	public String getAussicht() {
		return aussicht;
	}


	public void setAussicht(String aussicht) {
		this.aussicht = aussicht;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLetztesRenovierungsdatum() {
		return letztesRenovierungsdatum;
	}


	public void setLetztesRenovierungsdatum(String letztesRenovierungsdatum) {
		this.letztesRenovierungsdatum = letztesRenovierungsdatum;
	}


	public int getRenovierungsanzahl() {
		return renovierungsanzahl;
	}


	public void setRenovierungsanzahl(int renovierungsanzahl) {
		this.renovierungsanzahl = renovierungsanzahl;
	}


	public String getLetzeRenovierung_Details() {
		return letzeRenovierung_Details;
	}


	public void setLetzeRenovierung_Details(String letzeRenovierung_Details) {
		this.letzeRenovierung_Details = letzeRenovierung_Details;
	}


	public Mitarbeiter getZugeordneterMitarbeiter() {
		return zugeordneterMitarbeiter;
	}


	public void setZugeordneterMitarbeiter(Mitarbeiter zugeordneterMitarbeiter) {
		this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
	}


}