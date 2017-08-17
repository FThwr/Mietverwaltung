package mietverwaltung.action;

import mietverwaltung.Mieter;
import mietverwaltung.menu.MenuManager;

public class MieterAnzeigenAction extends MenuManager implements Action {

	@Override
	public void action() {

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
