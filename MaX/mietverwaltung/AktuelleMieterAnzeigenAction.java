package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class AktuelleMieterAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {

		/*
		 * Jedes Element der ArrayList 'ownerList' wird ausgelesen. Die
		 * ArrayList beeinhaltet alle aktuellen Mieter.
		 */
		for (Mieter owner : ownerList) {

			System.out.println("Mieter ID:      " + owner.getKundenID());
			System.out.println("Name:           " + owner.getName());
			System.out.println("Vorname:        " + owner.getVorname());
			System.out.println("Geburtsdatum:   " + owner.getGeburtsdatum());
			System.out.println("Wohnung:        " + owner.getWohnungsnummer());
			System.out.println("E-Mail:         " + owner.getEmail());
			System.out.println("Adresse:        " + owner.getAdresse());
			System.out.println("Telefon:        " + owner.getTelefonnummer());
			System.out.println("");
		}

	}

}
