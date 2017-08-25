
package mietverwaltung.action;

import java.io.Serializable;

import action.Action;
import menu.MenuManager;
import mietverwaltung.Mietvertrag;

public class AbgeschlosseneMietverträgeAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        for (Mietvertrag abgeschlossenerMietvertrag : MenuManager.getBeendeteMietverträge()) {

            System.out.println("Mietvertrags-ID:              " + abgeschlossenerMietvertrag.getMietvertragID());

            if (abgeschlossenerMietvertrag.getWohnungsID() != -100) {
                System.out.println("Wohnungs-ID:                  " + abgeschlossenerMietvertrag.getWohnungsID());
            } else {
                System.out.println("Wohnungs-ID:                  " + "-");
            }
            if (abgeschlossenerMietvertrag.getKundenID() != -100) {
                System.out.println("Kunden-ID:                    " + abgeschlossenerMietvertrag.getKundenID());
            } else {
                System.out.println("Kunden-ID                     " + abgeschlossenerMietvertrag.getKundenID());
            }
            if (abgeschlossenerMietvertrag.getMitarbeiterID() != -100) {
                System.out.println("Mitarbeiter-ID:               " + abgeschlossenerMietvertrag.getMitarbeiterID());
            } else {
                System.out.println("Mitarbeiter-ID:               " + "-");
            }
            if (abgeschlossenerMietvertrag.getMietbeginn() != null) {
                System.out.println("Mietbeginn:                   " + abgeschlossenerMietvertrag.getMietbeginn());
            } else {
                System.out.println("Mietbeginn:                   " + "-");
            }
            if (abgeschlossenerMietvertrag.getMietende() != null) {
                System.out.println("Mietende:                     " + abgeschlossenerMietvertrag.getMietende());
            } else {
                System.out.println("Mietende:                     " + "-");
            }
            System.out.println("Status:                       " + abgeschlossenerMietvertrag.getStatus());

            System.out.println("");
        }
    }
}