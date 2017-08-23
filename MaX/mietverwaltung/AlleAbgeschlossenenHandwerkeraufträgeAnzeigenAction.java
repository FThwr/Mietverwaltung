package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class AlleAbgeschlossenenHandwerkeraufträgeAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.println(
				"________________________________________ abgeschlossene Handwerkeraufträge anzeigen ________________________________________");

		/*
		 * Jedes Element der ArrayList 'abgeschlosseneHandwerkeraufträge' wird
		 * ausgelesen z.B. die Auftragsnummer, das Eingangsdatum des Auftrags,
		 * etc. Die ArrayList beeinhaltet alle abgeschlossenen
		 * Handwerkeraufträge.
		 */
		for (Handwerkerauftrag fertigerAuftrag : abgeschlosseneHandwerkeraufträge) {

			System.out.println("Auftrags ID: " + fertigerAuftrag.getAuftragsID());
			System.out.println("Wohnungs ID: " + fertigerAuftrag.getWohnungsID());
			System.out.println("Mitarbeiter ID: " + fertigerAuftrag.getMitarbeiterID());
			System.out.println("Mängelbeschreibung: " + fertigerAuftrag.getMängelbeschreibung());
			System.out.println("Status: " + fertigerAuftrag.getStatus());
			System.out.println("Eingangsdatum: " + fertigerAuftrag.getEingangsdatum());
			System.out.println("Fertigstellungsdatum: " + fertigerAuftrag.getFertigstellungsDatum());
			System.out.println("");
		}

	}

}