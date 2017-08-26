package mietverwaltung;

import java.io.Serializable;

public class AbgeschlosseneMietvertr�geAnzeigenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {
		
		System.out.println(
				"________________________________________ ehemalige Mietvertr�ge anzeigen ________________________________________\n");

		/*
		 * Es wird eine �bersicht �ber alle ehemaligen Mietvertr�ge ausgegeben.
		 */
		for (Mietvertrag abgeschlossenerMietvertrag : beendeteMietvertr�ge) {

			System.out.println("Mietvertrags-ID:              " + abgeschlossenerMietvertrag.getMietvertragID());

			if (abgeschlossenerMietvertrag.getWohnungsID() != -100) {
				System.out.println("Wohnungs-ID:                  " + abgeschlossenerMietvertrag.getWohnungsID());
			} else {
				System.out.println("Wohnungs-ID:                  " + "-");
			}
			if (abgeschlossenerMietvertrag.getKundenID() != -100) {
				System.out.println("Kunden-ID:                    " + abgeschlossenerMietvertrag.getKundenID());
			} else {
				System.out.println("Kunden-ID                     " + "-");
			}
			if (abgeschlossenerMietvertrag.getMitarbeiterID() != -100) {
				System.out.println("Mitarbeiter-ID:               " + abgeschlossenerMietvertrag.getMitarbeiterID());
			} else {
				System.out.println("Mitarbeiter-ID:               " + "-");
			}
			if (abgeschlossenerMietvertrag.getMietbeginn() != null) {
				System.out.println("Mietbeginn:                   " + abgeschlossenerMietvertrag.getMietbeginn());
			} else {
				System.out.println("Mietbeginn:                   " + "--.--.----");
			}
			if (abgeschlossenerMietvertrag.getMietende() != null) {
				System.out.println("Mietende:                     " + abgeschlossenerMietvertrag.getMietende());
			} else {
				System.out.println("Mietende:                     " + "--.--.----");
			}
			System.out.println("Status:                       " + abgeschlossenerMietvertrag.getStatus());
			System.out.println("");
		}
	}
}