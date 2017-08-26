package mietverwaltung;

import java.io.Serializable;

public class AktiveHandwerkerauftr�geAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ aktive Handwerkerauftr�ge anzeigen ________________________________________\n");

		/*
		 * Es wird eine �bersicht �ber alle aktiven Handwerkerauftr�ge ausgegeben.
		 */
		for (Handwerkerauftrag repair : repairList) {

			System.out.println("Auftrags ID: " + repair.getAuftragsID());
			if (repair.getWohnungsID() != -100) {
			System.out.println("Wohnungs ID: " + repair.getWohnungsID());
			} 
			else {
				System.out.println("Wohnungs ID: " + "-");
			}
			if (repair.getMitarbeiterID() != -100) {
			System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
			} 
			else {
				System.out.println("Mitarbeiter ID: " + "-");
			}
			System.out.println("M�ngelbeschreibung: " + repair.getM�ngelbeschreibung());
			System.out.println("Status: " + repair.getStatus());
			if (repair.getEingangsdatum() != null) {
			System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
			}
			else {
				System.out.println("Eingangsdatum: " + "--.--.----");
			}
			if (repair.getFertigstellungsDatum() != null) {
			System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
			}
			else {
				System.out.println("Fertigstellungsdatum: " + "--.--.----");
			}
			System.out.println("");
		}

	}

}
