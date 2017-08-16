package mietverwaltung;

public class Handwerkerauftrag {
	
	private String auftragsID;
	private int wohnungsID;
	private int mitarbeiterID;
	private String m�ngelbeschreibung;
	private String status;
	private Datum eingangsdatum;
	private Datum fertigstellungsDatum;
	
	
	public Handwerkerauftrag(String auftragsID, int wohnungsID, int mitarbeiterID, String m�ngelbeschreibung,
			String status, Datum eingangsdatum, Datum fertigstellungsDatum) {
		this.auftragsID = auftragsID;
		this.wohnungsID = wohnungsID;
		this.mitarbeiterID = mitarbeiterID;
		this.m�ngelbeschreibung = m�ngelbeschreibung;
		this.status = status;
		this.eingangsdatum = eingangsdatum;
		this.fertigstellungsDatum = fertigstellungsDatum;
	}
	
	public Handwerkerauftrag(String auftragsID) {
		this.auftragsID = auftragsID;
	}

	public String getAuftragsID() {
		return auftragsID;
	}

	public void setAuftragsID(String auftragsID) {
		this.auftragsID = auftragsID;
	}

	public String getM�ngelbeschreibung() {
		return m�ngelbeschreibung;
	}

	public void setM�ngelbeschreibung(String m�ngelbeschreibung) {
		this.m�ngelbeschreibung = m�ngelbeschreibung;
	}

	public int getWohnungsID() {
		return wohnungsID;
	}

	public void setWohnungsID(int wohnungsID) {
		this.wohnungsID = wohnungsID;
	}

	public int getMitarbeiterID() {
		return mitarbeiterID;
	}

	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Datum getEingangsdatum() {
		return eingangsdatum;
	}

	public void setEingangsdatum(Datum eingangsdatum) {
		this.eingangsdatum = eingangsdatum;
	}

	public Datum getFertigstellungsDatum() {
		return fertigstellungsDatum;
	}

	public void setFertigstellungsDatum(Datum fertigstellungsDatum) {
		this.fertigstellungsDatum = fertigstellungsDatum;
	} 

	
}
