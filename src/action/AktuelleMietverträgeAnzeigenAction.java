package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mietvertrag;

public class AktuelleMietverträgeAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktive Mietverträge anzeigen ________________________________________\n");

        /*
        * Es wird eine Übersicht über alle aktiven Mietverträge ausgegeben.
        */

        for (Mietvertrag contract : MenuManager.getContractList()) {

            System.out.println("Mietvertrags-ID:              " + contract.getMietvertragsID());

            if (contract.getWohnungsID() != -100) {
                System.out.println("Wohnungs-ID:                  " + contract.getWohnungsID());
            } else {
                System.out.println("Wohnungs-ID:                  " + "-");
            }
            if (contract.getKundenID() != -100) {
                System.out.println("Kunden-ID:                    " + contract.getKundenID());
            } else {
                System.out.println("Kunden-ID                     " + "-");
            }
            if (contract.getMitarbeiterID() != -100) {
                System.out.println("Mitarbeiter-ID:               " + contract.getMitarbeiterID());
            } else {
                System.out.println("Mitarbeiter-ID:               " + "-");
            }
            if (contract.getMietBeginn() != null) {
                System.out.println("Mietbeginn:                   " + contract.getMietBeginn());
            } else {
                System.out.println("Mietbeginn:                   " + "--.--.----");
            }
            if (contract.getMietEnde() != null) {
                System.out.println("Mietende:                     " + contract.getMietEnde());
            } else {
                System.out.println("Mietende:                     " + "--.--.----");
            }
            System.out.println("Status:                       " + contract.getStatus());
            System.out.println("");
        }
    }
}