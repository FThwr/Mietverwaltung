package mietverwaltung;

import java.io.Serializable;

public class AktiveHandwerkerauftr�geAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Handwerkerauftrag anzeigen ________________________________________");

		/*
		 * Jedes Element der ArrayList 'repairList' wird ausgelesen z.B. die
		 * Auftragsnummer, das Eingangsdatum des Auftrags, etc. Die ArrayList
		 * beeinhaltet alle zurzeit aktiven Handwerkerauftr�ge.
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
