package mietverwaltung;

import java.io.Serializable;

public class Bedingung implements Serializable{

	private double wunschwert;
	private int rela;
	private int krit;
	public Bedingung(int krit, int rela, double wunschwert) {
		
		this.wunschwert = wunschwert;
		this.rela = rela;
		this.krit = krit;
	}
	public double getWunschwert() {
		return wunschwert;
	}
	public void setWunschwert(double wunschwert) {
		this.wunschwert = wunschwert;
	}
	public int getRela() {
		return rela;
	}
	public void setRela(int rela) {
		this.rela = rela;
	}
	public int getKrit() {
		return krit;
	}
	public void setKrit(int krit) {
		this.krit = krit;
	}
}
