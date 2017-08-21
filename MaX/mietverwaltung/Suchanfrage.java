package mietverwaltung;

import java.io.Serializable;

public class Suchanfrage implements Serializable {
	
	private int mitarbeiterID;
	private int kundenID;
	private double zimmeranzahl;
	private double fl‰che;
	private double kosten;
	private double etage;
	private boolean balkon;
	private boolean fuﬂbodenheizung;
	private String aussicht;
	private Gregorien aktuellesDatum;
	public Suchanfrage(int mitarbeiterID, int kundenID, double such_zimmeranzahl, double fl‰che, double kosten, double such_etage,
			boolean balkon, boolean fuﬂbodenheizung, String aussicht, Gregorien aktuellesDatum) {
		
		this.mitarbeiterID = mitarbeiterID;
		this.kundenID = kundenID;
		this.zimmeranzahl = such_zimmeranzahl;
		this.fl‰che = fl‰che;
		this.kosten = kosten;
		this.etage = such_etage;
		this.balkon = balkon;
		this.fuﬂbodenheizung = fuﬂbodenheizung;
		this.aussicht = aussicht;
		this.
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
