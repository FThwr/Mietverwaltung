package mietverwaltung;

import java.io.Serializable;

public class Mietvertrag implements Serializable {
	
	private String mietvertragID;
	private int wohnungsID;
	private int kundenID;
	private int mitarbeiterID;
	private Datum mietbeginn;
	private Datum mietende;
	private String status; 
	
	public Mietvertrag(String mietvertragID, int wohnungsID, int kundenID, int mitarbeiterID, Datum mietbeginn, Datum mietende, String status) {
		
		this.mietvertragID = mietvertragID;
		this.wohnungsID = wohnungsID;
		this.kundenID = kundenID;
		this.mitarbeiterID = mitarbeiterID;
		this.mietbeginn = mietbeginn;
		this.mietende = mietende;
		this.status = status;
	}
	
	public int getWohnungsID() {
		return wohnungsID;
	}
	public void setWohnungsID(int wohnungsID) {
		this.wohnungsID = wohnungsID;
	}
	public int getKundenID() {
		return kundenID;
	}
	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}
	public int getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}
	public Datum getMietbeginn() {
		return mietbeginn;
	}
	public void setMietbeginn(Datum mietbeginn) {
		this.mietbeginn = mietbeginn;
	}
	public Datum getMietende() {
		return mietende;
	}
	public void setMietende(Datum mietende) {
		this.mietende = mietende;
	}
	public String getMietvertragID() {
		return mietvertragID;
	}
	public void setMietvertragID(String mietvertragID) {
		this.mietvertragID = mietvertragID;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	 

}
