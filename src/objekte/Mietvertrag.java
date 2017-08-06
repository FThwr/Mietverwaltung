package objekte;

import hilfsklassen.Datum;

public class Mietvertrag {
	
	private int mietvertragsID;
	private int wohnungsID;
	private int kundenID;
	private Datum mietBeginn;
	private Datum mietEnde;
	
	public Mietvertrag(int mietvertragID, int wohnungsID, int kundenID, int mitarbeiterID, Datum mietBeginn, Datum mietEnde) {
		this.mietvertragsID = mietvertragID;
		this.wohnungsID = wohnungsID;
		this.kundenID = kundenID;
		this.mietBeginn = mietBeginn;
		this.mietEnde = mietEnde;
	}

}
