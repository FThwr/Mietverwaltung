package mietverwaltung;

import java.io.Serializable;

public class Suchanfrage implements Serializable {
	
	private int mitarbeiterID;
	private int kundenID;
	private double zimmeranzahl;
	private char relaZimmeranzahl;
	private double fl‰che;
	private char relaFl‰che;
	private double kosten;
	private char relaKosten;
	private double etage;
	private char relaEtage;
	private boolean balkon;
	private boolean fuﬂbodenheizung;
	private String aussicht;
	public Suchanfrage(int mitarbeiterID, int kundenID, char relaZimmeranzahl , double such_zimmeranzahl, char relaFl‰che, double fl‰che, char relaKosten, double kosten, char relaEtage, double such_etage,
			boolean balkon, boolean fuﬂbodenheizung, String aussicht) {
		
		this.mitarbeiterID = mitarbeiterID;
		this.kundenID = kundenID;
		this.zimmeranzahl = such_zimmeranzahl;
		this.relaZimmeranzahl = relaZimmeranzahl;
		this.fl‰che = fl‰che;
		this.relaFl‰che = relaFl‰che;
		this.kosten = kosten;
		this.relaKosten = relaKosten;
		this.etage = such_etage;
		this.relaEtage = relaEtage;
		this.balkon = balkon;
		this.fuﬂbodenheizung = fuﬂbodenheizung;
		this.aussicht = aussicht;
	}
	public char getRelaZimmeranzahl() {
		return relaZimmeranzahl;
	}
	public void setRelaZimmeranzahl(char relaZimmeranzahl) {
		this.relaZimmeranzahl = relaZimmeranzahl;
	}
	public char getRelaFl‰che() {
		return relaFl‰che;
	}
	public void setRelaFl‰che(char relaFl‰che) {
		this.relaFl‰che = relaFl‰che;
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

}
