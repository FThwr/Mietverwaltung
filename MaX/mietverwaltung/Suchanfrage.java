package mietverwaltung;

import java.io.Serializable;

public class Suchanfrage implements Serializable {
	
	private int mitarbeiterID;
	private int kundenID;
	private double zimmeranzahl;
	private char relaZimmeranzahl;
	private double fläche;
	private char relaFläche;
	private double kosten;
	private char relaKosten;
	private double etage;
	private char relaEtage;
	private boolean balkon;
	private boolean fußbodenheizung;
	private String aussicht;
	private Gregorien aktuellesDatum;
	public Suchanfrage(int mitarbeiterID, int kundenID, char relaZimmeranzahl , double such_zimmeranzahl, char relaFläche, double fläche, char relaKosten, double kosten, char relaEtage, double such_etage,
			boolean balkon, boolean fußbodenheizung, String aussicht, Gregorien aktuellesDatum) {
		
		this.mitarbeiterID = mitarbeiterID;
		this.kundenID = kundenID;
		this.zimmeranzahl = such_zimmeranzahl;
		this.relaZimmeranzahl = relaZimmeranzahl;
		this.fläche = fläche;
		this.relaFläche = relaFläche;
		this.kosten = kosten;
		this.relaKosten = relaKosten;
		this.etage = such_etage;
		this.relaEtage = relaEtage;
		this.balkon = balkon;
		this.fußbodenheizung = fußbodenheizung;
		this.aussicht = aussicht;
		this.aktuellesDatum = aktuellesDatum;
	}
	public char getRelaZimmeranzahl() {
		return relaZimmeranzahl;
	}
	public void setRelaZimmeranzahl(char relaZimmeranzahl) {
		this.relaZimmeranzahl = relaZimmeranzahl;
	}
	public char getRelaFläche() {
		return relaFläche;
	}
	public void setRelaFläche(char relaFläche) {
		this.relaFläche = relaFläche;
	}
	public char getRelaKosten() {
		return relaKosten;
	}
	public void setRelaKosten(char relaKosten) {
		this.relaKosten = relaKosten;
	}
	public char getRelaEtage() {
		return relaEtage;
	}
	public void setRelaEtage(char relaEtage) {
		this.relaEtage = relaEtage;
	}
	public Gregorien getAktuellesDatum() {
		return aktuellesDatum;
	}
	public void setAktuellesDatum(Gregorien aktuellesDatum) {
		this.aktuellesDatum = aktuellesDatum;
	}
	public int getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}
	public int getKundenID() {
		return kundenID;
	}
	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}
	public double getZimmeranzahl() {
		return zimmeranzahl;
	}
	public void setZimmeranzahl(double zimmeranzahl) {
		this.zimmeranzahl = zimmeranzahl;
	}
	public double getFläche() {
		return fläche;
	}
	public void setFläche(double fläche) {
		this.fläche = fläche;
	}
	public double getKosten() {
		return kosten;
	}
	public void setKosten(double kosten) {
		this.kosten = kosten;
	}
	public double getEtage() {
		return etage;
	}
	public void setEtage(double etage) {
		this.etage = etage;
	}
	public boolean getBalkon() {
		return balkon;
	}
	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}
	public boolean getFußbodenheizung() {
		return fußbodenheizung;
	}
	public void setFußbodenheizung(boolean fußbodenheizung) {
		this.fußbodenheizung = fußbodenheizung;
	}
	public String getAussicht() {
		return aussicht;
	}
	public void setAussicht(String aussicht) {
		this.aussicht = aussicht;
	}

}
