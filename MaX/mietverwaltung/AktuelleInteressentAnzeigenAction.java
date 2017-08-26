package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class AktuelleInteressentAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException{

		System.out.println(
				"________________________________________ aktuelle Interessent anzeigen ________________________________________\n");

		/*
		 * Es wird eine Übersicht über alle aktuellen Interessenten ausgegeben.
		 */

		for (Interessent interest : interestList) {

			if (interest.getKundenID() != -100) {
			System.out.println("Interessenten ID: " + interest.getKundenID());
			} 
			else {
				System.out.println("Interessenten ID: " + "-");
			}
			System.out.println("Name:             " + interest.getName());
			System.out.println("Vorname:          " + interest.getVorname());
			if (interest.getGeburtsdatum() != null) {
			System.out.println("Geburtsdatum:     " + interest.getGeburtsdatum());
			}
			else {
				System.out.println("Geburtsdatum:     " + "--.--.----");
			}
			System.out.println("E-Mail:           " + interest.getEmail());
			System.out.println("Adresse:          " + interest.getAdresse());
			System.out.println("Telefon:          " + interest.getTelefonnummer());
			System.out.println("");
		}

	}

}
