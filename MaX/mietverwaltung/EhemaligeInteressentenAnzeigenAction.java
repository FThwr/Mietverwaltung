package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class EhemaligeInteressentenAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.println(
				"________________________________________ ehemalige Interessent anzeigen ________________________________________");

		/*
		 * Es wird eine Übersicht über alle ehemaligen Interessenten ausgegeben.
		 */

		for (Interessent ehemaligerInteressent : ehemaligeInteressenten) {

			System.out.println("Interessenten ID: " + ehemaligerInteressent.getKundenID());
			System.out.println("Name:             " + ehemaligerInteressent.getName());
			System.out.println("Vorname:          " + ehemaligerInteressent.getVorname());
			System.out.println("Geburtsdatum:     " + ehemaligerInteressent.getGeburtsdatum());
			System.out.println("E-Mail:           " + ehemaligerInteressent.getEmail());
			System.out.println("Adresse:          " + ehemaligerInteressent.getAdresse());
			System.out.println("Telefon:          " + ehemaligerInteressent.getTelefonnummer());
			System.out.println("");
		}

	}

}
