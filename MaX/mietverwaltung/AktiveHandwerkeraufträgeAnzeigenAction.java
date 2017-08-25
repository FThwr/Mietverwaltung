package mietverwaltung;

import java.io.Serializable;

public class AktiveHandwerkerauftr�geAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ aktive Handwerkerauftr�ge anzeigen ________________________________________");

		/*
		 * Es wird eine �bersicht �ber alle aktiven Handwerkerauftr�ge ausgegeben.
		 */
		for (Handwerkerauftrag repair : repairList) {

			System.out.println("Auftrags ID: " + repair.getAuftragsID());
			System.out.println("Wohnungs ID: " + repair.getWohnungsID());
			System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
			System.out.println("M�ngelbeschreibung: " + repair.getM�ngelbeschreibung());
			System.out.println("Status: " + repair.getStatus());
			System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
			System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
			System.out.println("");
		}

	}

}
