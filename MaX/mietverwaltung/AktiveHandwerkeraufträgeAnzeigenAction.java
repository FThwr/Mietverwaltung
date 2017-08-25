package mietverwaltung;

import java.io.Serializable;

public class AktiveHandwerkeraufträgeAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ aktive Handwerkeraufträge anzeigen ________________________________________");

		/*
		 * Es wird eine Übersicht über alle aktiven Handwerkeraufträge ausgegeben.
		 */
		for (Handwerkerauftrag repair : repairList) {

			System.out.println("Auftrags ID: " + repair.getAuftragsID());
			System.out.println("Wohnungs ID: " + repair.getWohnungsID());
			System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
			System.out.println("Mängelbeschreibung: " + repair.getMängelbeschreibung());
			System.out.println("Status: " + repair.getStatus());
			System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
			System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
			System.out.println("");
		}

	}

}
