package mietverwaltung;

import java.io.Serializable;

import mietverwaltung.Mietvertrag;

public class Wohnung implements Serializable{
	
	private int wohnungsID;
	private int zimmeranzahl;
	private double fl‰che;
	private double kosten;
	private int etage;
	private boolean balkon;
	private boolean fuﬂbodenheizung;
	private String aussicht;
	private Adresse adresse;
	private String status;
	private Datum letztesRenovierungsdatum;
	private int renovierungsanzahl;
	private String letzeRenovierung_Details;
	private Handwerkerauftrag handwerkerauftrag;
	private Mitarbeiter zugeordneterMitarbeiter;
	
	
	public Wohnung(int wohnungsID, int zimmeranzahl, double fl‰che, double kosten, int etage, boolean balkon,boolean fuﬂbodenheizung, String aussicht, Adresse adresse, String status, 
			Datum letztesRenovierungsdatum, int renovierungsanzahl, String letzeRenovierung_Details, Handwerkerauftrag handwerkerauftrag, Mitarbeiter zugeordneterMitarbeiter) {
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
		this.handwerkerauftrag = handwerkerauftrag;
		this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
	}

	public Handwerkerauftrag getHandwerkerauftrag() {
		return handwerkerauftrag;
	}

	public void setHandwerkerauftrag(Handwerkerauftrag handwerkerauftrag) {
		this.handwerkerauftrag = handwerkerauftrag;
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


	public boolean getBalkon() {
		return balkon;
	}


	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}


	public boolean getFuﬂbodenheizung() {
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


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Datum getLetztesRenovierungsdatum() {
		return letztesRenovierungsdatum;
	}


	public void setLetztesRenovierungsdatum(Datum letztesRenovierungsdatum) {
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
