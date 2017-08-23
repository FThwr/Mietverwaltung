package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class EhemaligeMieterAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		/*
		 * Jedes Element der ArrayList 'ehemaligeMieter' wird ausgelesen. Die
		 * ArrayList beeinhaltet alle ehemaligen Mieter.
		 */
		for (Mieter ehemaligerMieter : ehemaligeMieter) {

			System.out.println("Mieter ID:      " + ehemaligerMieter.getKundenID());
			System.out.println("Name:           " + ehemaligerMieter.getName());
			System.out.println("Vorname:        " + ehemaligerMieter.getVorname());
			System.out.println("Geburtsdatum:   " + ehemaligerMieter.getGeburtsdatum());
			System.out.println("Wohnung:        " + ehemaligerMieter.getWohnungsnummer());
			System.out.println("E-Mail:         " + ehemaligerMieter.getEmail());
			System.out.println("Adresse:        " + ehemaligerMieter.getAdresse());
			System.out.println("Telefon:        " + ehemaligerMieter.getTelefonnummer());
			System.out.println("");
		}

	}

}
