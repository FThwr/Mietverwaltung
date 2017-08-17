package mietverwaltung.action;

import mietverwaltung.Mietvertrag;
import mietverwaltung.menu.MenuManager;

public class MietvertragAnzeigenAction extends MenuManager implements Action {

	@Override
	public void action() {

		for (Mietvertrag contract : contractList) {

			System.out.println("Mietvertrags-ID:              " + contract.getMietvertragID());

			if (contract.getWohnungsID() != -100) {
				System.out.println("Wohnungs-ID:                  " + contract.getWohnungsID());
			} else {
				System.out.println("Wohnungs-ID:                  " + "-");
			}
			if (contract.getKundenID() != -100) {
				System.out.println("Kunden-ID:                    " + contract.getKundenID());
			} else {
				System.out.println("Kunden-ID                     " + contract.getKundenID());
			}
			if (contract.getMitarbeiterID() != -100) {
				System.out.println("Mitarbeiter-ID:               " + contract.getMitarbeiterID());
			} else {
				System.out.println("Mitarbeiter-ID:               " + "-");
			}
			if (contract.getMietbeginn() != null) {
				System.out.println("Mietbeginn:                   " + contract.getMietbeginn());
			} else {
				System.out.println("Mietbeginn:                   " + "-");
			}
			if (contract.getMietende() != null) {
				System.out.println("Mietende:                     " + contract.getMietende());
			} else {
				System.out.println("Mietende:                     " + "-");
			}

			System.out.println("");
		}
	}
}