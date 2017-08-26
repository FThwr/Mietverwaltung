package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mietvertrag;

public class AbgeschlosseneMietvertr�geAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ ehemalige Mietvertr�ge anzeigen ________________________________________\n");

        /*
        * Es wird eine �bersicht �ber alle ehemaligen Mietvertr�ge ausgegeben.
        */
        for (Mietvertrag abgeschlossenerMietvertrag : MenuManager.getBeendeteMietvertr�ge()) {

            System.out.println("Mietvertrags-ID:              " + abgeschlossenerMietvertrag.getMietvertragsID());

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
            if (abgeschlossenerMietvertrag.getMietBeginn() != null) {
                System.out.println("Mietbeginn:                   " + abgeschlossenerMietvertrag.getMietBeginn());
            } else {
                System.out.println("Mietbeginn:                   " + "--.--.----");
            }
            if (abgeschlossenerMietvertrag.getMietEnde() != null) {
                System.out.println("Mietende:                     " + abgeschlossenerMietvertrag.getMietEnde());
            } else {
                System.out.println("Mietende:                     " + "--.--.----");
            }
            System.out.println("Status:                       " + abgeschlossenerMietvertrag.getStatus());

            System.out.println("");
        }
    }
}