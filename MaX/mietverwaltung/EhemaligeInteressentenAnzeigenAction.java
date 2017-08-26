package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class EhemaligeInteressentenAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.println(
				"________________________________________ ehemalige Interessent anzeigen ________________________________________\n");

		/*
		 * Es wird eine Übersicht über alle ehemaligen Interessenten ausgegeben.
		 */

		for (Interessent ehemaligerInteressent : ehemaligeInteressenten) {

			if (ehemaligerInteressent.getKundenID() != -100) {
			System.out.println("Interessenten ID: " + ehemaligerInteressent.getKundenID());
			}
			else {
				System.out.println("Interessenten ID: " + "-");
			}
			System.out.println("Name:             " + ehemaligerInteressent.getName());
			System.out.println("Vorname:          " + ehemaligerInteressent.getVorname());
			if (ehemaligerInteressent.getGeburtsdatum() != null) {
			System.out.println("Geburtsdatum:     " + ehemaligerInteressent.getGeburtsdatum());
			}
			else {
				System.out.println("Geburtsdatum:     " + "--.--.----");
			}
			System.out.println("E-Mail:           " + ehemaligerInteressent.getEmail());
			System.out.println("Adresse:          " + ehemaligerInteressent.getAdresse());
			System.out.println("Telefon:          " + ehemaligerInteressent.getTelefonnummer());
			System.out.println("");
		}

	}

}
