package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class AbgeschlossenenHandwerkeraufträgeAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.println(
				"________________________________________ abgeschlossene Handwerkeraufträge anzeigen ________________________________________\n");

		/*
		 * Es wird eine Übersicht über alle abgeschlossene Handwerkeraufträge ausgegeben.
		 */
		for (Handwerkerauftrag fertigerAuftrag : abgeschlosseneHandwerkeraufträge) {

			System.out.println("Auftrags ID: " + fertigerAuftrag.getAuftragsID());
			if (fertigerAuftrag.getWohnungsID() != -100) {
			System.out.println("Wohnungs ID: " + fertigerAuftrag.getWohnungsID());
			}
			else {
				System.out.println("Wohnungs ID: " + "-");
			}
			if (fertigerAuftrag.getMitarbeiterID() != -100) {
			System.out.println("Mitarbeiter ID: " + fertigerAuftrag.getMitarbeiterID());
			}
			else {
				System.out.println("Mitarbeiter ID: " + "-");
			}
			System.out.println("Mängelbeschreibung: " + fertigerAuftrag.getMängelbeschreibung());
			System.out.println("Status: " + fertigerAuftrag.getStatus());
			if (fertigerAuftrag.getEingangsdatum() != null) {
			System.out.println("Eingangsdatum: " + fertigerAuftrag.getEingangsdatum());
			} 
			else {
				System.out.println("Eingangsdatum: " + "--.--.----");
			}
			if (fertigerAuftrag.getFertigstellungsDatum() != null) {
			System.out.println("Fertigstellungsdatum: " + fertigerAuftrag.getFertigstellungsDatum());
			}
			else {
				System.out.println("Fertigstellungsdatum: " + "--.--.----");
			}
			System.out.println("");
		}

	}

}